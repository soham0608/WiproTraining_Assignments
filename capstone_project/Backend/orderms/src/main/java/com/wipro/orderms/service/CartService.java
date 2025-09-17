package com.wipro.orderms.service;

import com.wipro.orderms.entity.Cart;

public interface CartService {
    
    Cart getCartByUserId(int userId);
    Cart addProductToCart(int userId, int productId, int quantity);
    Cart updateProductQuantity(int userId, int productId, int quantity);
    void removeProductFromCart(int userId, int productId);
    void clearCart(int userId);
    Cart createNewCart(int userId);
    void updateCartTotals(Cart cart);
    void clearCartByUserId(int userId);    
}