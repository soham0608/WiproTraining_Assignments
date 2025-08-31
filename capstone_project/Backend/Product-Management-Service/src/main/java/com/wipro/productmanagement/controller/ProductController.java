package com.wipro.productmanagement.controller;

import com.wipro.productmanagement.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/check/{productId}/{quantity}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable Integer productId,
                                                     @PathVariable Integer quantity) {
        boolean available = productService.checkAvailability(productId, quantity);
        return ResponseEntity.ok(available);
    }

    @PutMapping("/reduce/{productId}/{quantity}")
    public ResponseEntity<String> reduceQuantity(@PathVariable Integer productId,
                                                 @PathVariable Integer quantity) {
        productService.reduceQuantity(productId, quantity);
        return ResponseEntity.ok("Quantity reduced successfully");
    }

    @PutMapping("/increase/{productId}/{quantity}")
    public ResponseEntity<String> increaseQuantity(@PathVariable Integer productId,
                                                   @PathVariable Integer quantity) {
        productService.increaseQuantity(productId, quantity);
        return ResponseEntity.ok("Quantity increased successfully");
    }
}
