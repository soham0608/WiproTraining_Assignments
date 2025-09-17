package com.wipro.orderms.controller;

import com.wipro.orderms.entity.Cart;
import com.wipro.orderms.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cart")
@Tag(name = "Cart Management", description = "APIs for managing shopping cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @Operation(summary = "Get user's cart")
    @ApiResponse(responseCode = "200", description = "Cart retrieved successfully")
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Integer userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }
    
    @Operation(summary = "Add product to cart")
    @ApiResponse(responseCode = "200", description = "Product added to cart successfully")
    @PostMapping("/addProd")
    public ResponseEntity<Cart> addProductToCart(
            @RequestParam Integer userId,
            @RequestParam Integer productId,
            @RequestParam Integer quantity) {
        Cart cart = cartService.addProductToCart(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }
    
    @Operation(summary = "Update product quantity in cart")
    @ApiResponse(responseCode = "200", description = "Cart updated successfully")
    @PutMapping("/update")
    public ResponseEntity<Cart> updateCartItem(
            @RequestParam Integer userId,
            @RequestParam Integer productId,
            @RequestParam Integer quantity) {
        Cart cart = cartService.updateProductQuantity(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }
    
    @Operation(summary = "Remove product from cart")
    @ApiResponse(responseCode = "200", description = "Product removed from cart successfully")
    @DeleteMapping("/deleteProd/{userId}/{productId}")
    public ResponseEntity<Void> removeProductFromCart(
            @PathVariable Integer userId,
            @PathVariable Integer productId) {
        cartService.removeProductFromCart(userId, productId);
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Clear user's cart")
    @ApiResponse(responseCode = "200", description = "Cart cleared successfully")
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Void> clearCart(@PathVariable Integer userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok().build();
    }
}
