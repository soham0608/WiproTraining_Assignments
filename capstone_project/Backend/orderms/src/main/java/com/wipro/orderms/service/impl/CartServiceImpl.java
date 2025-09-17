package com.wipro.orderms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.wipro.orderms.dto.Product;
import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.exception.InsufficientQuantityException;
import com.wipro.orderms.exception.ProductNotFoundException;
import com.wipro.orderms.repo.CartRepo;
import com.wipro.orderms.service.CartService;


@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	String PRODUCT_SERVICE_URL = "http://PRODUCTMS";
    
    @Autowired
    private CartRepo cartRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Cart getCartByUserId(int userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> createNewCart(userId));
    }
    
    public Cart addProductToCart(int userId, int productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        
        // Verify product exists and has sufficient quantity
        ResponseEntity<Product> response = restTemplate.getForEntity(
        		PRODUCT_SERVICE_URL+"/products/" + productId, Product.class);
        
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new ProductNotFoundException("Product not found: " + productId);
        }
        
        Product product = response.getBody();
        if (product.getAvailableQty() < quantity) {
            throw new InsufficientQuantityException("Insufficient quantity for product: " + productId);
        }
        
        cart.getProdDetails().put(productId, quantity);
        updateCartTotals(cart);
        
        return cartRepository.save(cart);
    }
    
    public Cart updateProductQuantity(int userId, int productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        
        if (quantity <= 0) {
            cart.getProdDetails().remove(productId);
        } else {
            cart.getProdDetails().put(productId, quantity);
        }
        
        updateCartTotals(cart);
        return cartRepository.save(cart);
    }
    
    public void removeProductFromCart(int userId, int productId) {
        Cart cart = getCartByUserId(userId);
        cart.getProdDetails().remove(productId);
        updateCartTotals(cart);
        cartRepository.save(cart);
    }
    
    public void clearCart(int userId) {
        cartRepository.deleteByUserId(userId);
    }
    
    @Override
    @Transactional
    public void clearCartByUserId(int userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));

        // Clear all product entries
        cart.getProdDetails().clear();

        // Reset totals
        cart.setTotalQty(0);
        cart.setTotalPrice(0.0);

        cartRepository.save(cart);
    }
    
    public Cart createNewCart(int userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProdDetails(new HashMap<>());
        cart.setTotalQty(0);
        cart.setTotalPrice(0.0);
        return cartRepository.save(cart);
    }
    
    public void updateCartTotals(Cart cart) {
    	int totalQty = 0;
        Double totalPrice = 0.0;
        
        for (Map.Entry<Integer, Integer> entry : cart.getProdDetails().entrySet()) {
        	int productId = entry.getKey();
        	int quantity = entry.getValue();
            
            ResponseEntity<Product> response = restTemplate.getForEntity(
            		PRODUCT_SERVICE_URL + "/products/" + productId, Product.class);
            
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            	Product product = response.getBody();
                totalQty += quantity;
                totalPrice += quantity * product.getPrice();
            }
        }
        
        cart.setTotalQty(totalQty);
        cart.setTotalPrice(totalPrice);
    }
}
