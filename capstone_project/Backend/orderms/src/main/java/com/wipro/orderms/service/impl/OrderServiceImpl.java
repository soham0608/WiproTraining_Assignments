package com.wipro.orderms.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.wipro.orderms.dto.Product;
import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.entity.Order;
import com.wipro.orderms.exception.EmptyCartException;
import com.wipro.orderms.exception.InvalidOrderStatusException;
import com.wipro.orderms.exception.OrderNotFoundException;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.service.CartService;
import com.wipro.orderms.service.OrderService;
import com.wipro.orderms.util.AppConstant;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	String PRODUCT_SERVICE_URL = "http://PRODUCTMS";

	@Autowired
    private OrderRepo orderRepository;
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    
    @Override
    public Order createOrder(int userId) {
        Cart cart = cartService.getCartByUserId(userId);

        if (cart.getProdDetails().isEmpty()) {
            throw new EmptyCartException("Cannot create order from empty cart");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setProductQuantityMap(new HashMap<>(cart.getProdDetails()));
        order.setTotalAmount(cart.getTotalPrice());
        order.setOrderStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());

        // ✅ Step 1: Deduct stock for each product
        for (Map.Entry<Integer, Integer> entry : cart.getProdDetails().entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            ResponseEntity<Product> response = restTemplate.getForEntity(
                    PRODUCT_SERVICE_URL + "/products/" + productId, Product.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Product product = response.getBody();

                if (product.getAvailableQty() < quantity) {
                    throw new RuntimeException("Insufficient stock for product: " + productId);
                }

                product.setAvailableQty(product.getAvailableQty() - quantity);

                // Update stock in ProductMS
                restTemplate.put(PRODUCT_SERVICE_URL + "/products/" + productId, product);
            } else {
                throw new RuntimeException("Product not found in ProductMS: " + productId);
            }
        }

        Order savedOrder = orderRepository.save(order);

        kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, savedOrder);

        cartService.clearCartByUserId(userId);

        return savedOrder;
    }

    
    public Order cancelOrder(int orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + orderId));
        
        if (!"CONFIRMED".equals(order.getOrderStatus())) {
            throw new InvalidOrderStatusException("Only confirmed orders can be cancelled");
        }
        
        // Restore product quantities
        for (Map.Entry<Integer, Integer> entry : order.getProductQuantityMap().entrySet()) {
        	int productId = entry.getKey();
            int quantity = entry.getValue();
            
            ResponseEntity<Product> response = restTemplate.getForEntity(
            		PRODUCT_SERVICE_URL + "/products/" + productId, Product.class);
            
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Product product = response.getBody();
                product.setAvailableQty(product.getAvailableQty() + quantity);
                restTemplate.put(PRODUCT_SERVICE_URL + "/products/" + productId, product);
            }
        }
        
        order.setOrderStatus("CANCELLED");
        return orderRepository.save(order);
    }
    
    public List<Order> getUserOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }
    
    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + orderId));
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Order updateOrderStatus(Integer orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderStatus(status);
        return orderRepository.save(order);
    }
}
