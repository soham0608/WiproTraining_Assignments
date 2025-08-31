package com.wipro.ordermanagement.service.impl;

import com.wipro.ordermanagement.dto.CartItemDTO;
import com.wipro.ordermanagement.dto.OrderDTO;
import com.wipro.ordermanagement.dto.OrderItemDTO;
import com.wipro.ordermanagement.entity.CartItem;
import com.wipro.ordermanagement.entity.Order;
import com.wipro.ordermanagement.entity.OrderItem;
import com.wipro.ordermanagement.repository.CartItemRepository;
import com.wipro.ordermanagement.repository.OrderItemRepository;
import com.wipro.ordermanagement.repository.OrderRepository;
import com.wipro.ordermanagement.service.OrderService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String productServiceUrl; // e.g. http://localhost:8082/products

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderItemRepository orderItemRepository,
                            CartItemRepository cartItemRepository,
                            RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public OrderDTO createOrder(Integer userId) {
        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
        if (cartItems.isEmpty()) throw new NotFoundException("Cart is empty for user " + userId);

        // 1. Create the order
        Order order = new Order();
        order.setUser_id(userId);
        order.setStatus(Order.Status.CREATED);
        Order savedOrder = orderRepository.save(order);

        // 2. Convert cart items -> order items
        List<OrderItem> orderItems = cartItems.stream().map(c -> {
            OrderItem item = new OrderItem();
            item.setOrder(savedOrder);
            item.setProduct_id(c.getProduct_id());
            item.setProduct_name(c.getProduct_name());
            item.setPrice(c.getPrice());
            item.setQuantity(c.getQuantity());
            return orderItemRepository.save(item);
        }).collect(Collectors.toList());

        order.setOrderItems(orderItems);

        // 3. Clear the cart
        cartItemRepository.deleteAll(cartItems);

        // 4. Call Product Service REST API to reduce stock
        orderItems.forEach(item -> {
            String url = productServiceUrl + "/reduce/" + item.getProduct_id() + "/" + item.getQuantity();
            restTemplate.put(url, null);
        });

        return mapToDTO(order);
    }

    @Override
    public OrderDTO cancelOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found: " + orderId));
        order.setStatus(Order.Status.CANCELLED);
        order = orderRepository.save(order);

        // order.getOrderItems().forEach(item -> {
        //     String url = productServiceUrl + "/increase/" + item.getProduct_id() + "/" + item.getQuantity();
        //     restTemplate.put(url, null);
        // });

        return mapToDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByUser(Integer userId) {
        return orderRepository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).map(this::mapToDTO)
                .orElseThrow(() -> new NotFoundException("Order not found: " + orderId));
    }

    @Override
    public CartItemDTO addToCart(CartItemDTO dto) {
        CartItem cart = new CartItem();
        cart.setUser_id(dto.getUser_id());
        cart.setProduct_id(dto.getProduct_id());
        cart.setProduct_name(dto.getProduct_name());
        cart.setQuantity(dto.getQuantity());
        cart.setPrice(dto.getPrice());
        return mapToCartDTO(cartItemRepository.save(cart));
    }

    @Override
    public void deleteCartItem(Integer cartId) {
        cartItemRepository.deleteById(cartId);
    }

    @Override
    public CartItemDTO updateCartItem(CartItemDTO dto) {
        CartItem cart = cartItemRepository.findById(dto.getCart_id())
                .orElseThrow(() -> new NotFoundException("Cart item not found: " + dto.getCart_id()));
        cart.setQuantity(dto.getQuantity());
        cart.setPrice(dto.getPrice());
        return mapToCartDTO(cartItemRepository.save(cart));
    }

    @Override
    public List<CartItemDTO> getCartItems(Integer userId) {
        return cartItemRepository.findByUserId(userId).stream().map(this::mapToCartDTO).collect(Collectors.toList());
    }

    // 🔹 Utility mappers
    private OrderDTO mapToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOid(order.getOid());
        dto.setUser_id(order.getUser_id());
        dto.setStatus(order.getStatus().name());
        if (order.getOrderItems() != null) {
            dto.setOrderItems(order.getOrderItems().stream().map(i -> {
                OrderItemDTO itemDTO = new OrderItemDTO();
                itemDTO.setId(i.getId());
                itemDTO.setProduct_id(i.getProduct_id());
                itemDTO.setProduct_name(i.getProduct_name());
                itemDTO.setPrice(i.getPrice());
                itemDTO.setQuantity(i.getQuantity());
                return itemDTO;
            }).collect(Collectors.toList()));
        }
        return dto;
    }

    private CartItemDTO mapToCartDTO(CartItem cart) {
        CartItemDTO dto = new CartItemDTO();
        dto.setCart_id(cart.getCart_id());
        dto.setUser_id(cart.getUser_id());
        dto.setProduct_id(cart.getProduct_id());
        dto.setProduct_name(cart.getProduct_name());
        dto.setQuantity(cart.getQuantity());
        dto.setPrice(cart.getPrice());
        return dto;
    }
}
