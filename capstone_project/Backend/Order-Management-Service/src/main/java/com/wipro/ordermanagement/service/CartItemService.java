package com.wipro.ordermanagement.service;

import java.util.List;

import com.wipro.ordermanagement.dto.CartItemDTO;

public interface CartItemService {
	
	CartItemDTO addToCart(CartItemDTO cartItemDto);
	
	CartItemDTO updateCartItem(Integer id, CartItemDTO cartItemDto);
	
    void removeCartItem(Integer id);
    
    List<CartItemDTO> getUserCart(Integer userId);
    
}
