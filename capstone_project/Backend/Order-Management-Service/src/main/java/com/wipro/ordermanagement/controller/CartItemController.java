package com.wipro.ordermanagement.controller;

import com.wipro.ordermanagement.dto.CartItemDTO;
import com.wipro.ordermanagement.service.CartItemService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/addProd")
    public ResponseEntity<CartItemDTO> addToCart(@Valid @RequestBody CartItemDTO cartItemDto) {
        CartItemDTO savedCartItem = cartItemService.addToCart(cartItemDto);
        return new ResponseEntity<>(savedCartItem, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CartItemDTO> updateCartItem(
            @PathVariable Integer id,
            @RequestBody CartItemDTO cartItemDto) {
        CartItemDTO updatedCartItem = cartItemService.updateCartItem(id, cartItemDto);
        return ResponseEntity.ok(updatedCartItem);
    }

    @DeleteMapping("/deleteProd/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Integer id) {
        cartItemService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItemDTO>> getUserCart(@PathVariable Integer userId) {
        List<CartItemDTO> userCart = cartItemService.getUserCart(userId);
        return ResponseEntity.ok(userCart);
    }
}
