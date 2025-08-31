package com.wipro.ordermanagement.controller;

import com.wipro.ordermanagement.dto.CartItemDTO;
import com.wipro.ordermanagement.dto.OrderDTO;
import com.wipro.ordermanagement.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ---------------- CART ----------------
    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/cart/addProd")
    public ResponseEntity<CartItemDTO> addCart(@RequestBody CartItemDTO dto) {
        return ResponseEntity.ok(orderService.addToCart(dto));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @DeleteMapping("/cart/deleteProd/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable Integer cartId) {
        orderService.deleteCartItem(cartId);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PutMapping("/cart/update")
    public ResponseEntity<CartItemDTO> updateCart(@RequestBody CartItemDTO dto) {
        return ResponseEntity.ok(orderService.updateCartItem(dto));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/cart/{userId}")
    public ResponseEntity<List<CartItemDTO>> getCart(@PathVariable Integer userId) {
        return ResponseEntity.ok(orderService.getCartItems(userId));
    }

    // ---------------- ORDER ----------------
    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/order")
    public ResponseEntity<OrderDTO> createOrder(@RequestParam Integer userId) {
        return ResponseEntity.ok(orderService.createOrder(userId));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PutMapping("/order/{orderId}/cancel")
    public ResponseEntity<OrderDTO> cancelOrder(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.cancelOrder(orderId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/order/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @PreAuthorize("hasRole('CUSTOMER') or hasRole('ADMIN')")
    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
