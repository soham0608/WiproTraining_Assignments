package com.wipro.ordermanagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.wipro.ordermanagement.dto.CartItemDTO;
import com.wipro.ordermanagement.entity.CartItem;
import com.wipro.ordermanagement.repository.CartItemRepository;
import com.wipro.ordermanagement.service.CartItemService;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }
    
    @Override
    public CartItemDTO addToCart(CartItemDTO cartItemDto) {
        CartItem cartItem = new CartItem();
        cartItem.setUser_id(cartItemDto.getUser_id());
        cartItem.setProduct_id(cartItemDto.getProduct_id());
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setPrice(cartItemDto.getPrice());

        return mapToDto(cartItemRepository.save(cartItem));
    }

    @Override
    public CartItemDTO updateCartItem(Integer id, CartItemDTO cartItemDto) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart Item with id: " +id+ " not found"));

        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setPrice(cartItemDto.getPrice());

        return mapToDto(cartItemRepository.save(cartItem));
    }

    @Override
    public void removeCartItem(Integer id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart Item with id: " +id+ " not found"));
        cartItemRepository.delete(cartItem);
    }

    @Override
    public List<CartItemDTO> getUserCart(Integer userId) {
        return cartItemRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private CartItemDTO mapToDto(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(cartItem.getId());
        dto.setUser_id(cartItem.getUser_id());
        dto.setProduct_id(cartItem.getProduct_id());
        dto.setQuantity(cartItem.getQuantity());
        dto.setPrice(cartItem.getPrice());
        return dto;
    }
}
