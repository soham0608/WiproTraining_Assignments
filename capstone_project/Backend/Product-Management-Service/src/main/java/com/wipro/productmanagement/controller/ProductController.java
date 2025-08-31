package com.wipro.productmanagement.controller;

import com.wipro.productmanagement.dto.ProductDTO;
import com.wipro.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id,
                                                    @Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.updateProduct(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/check/{id}/{qty}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable Integer id,
                                                     @PathVariable int qty) {
        return ResponseEntity.ok(productService.checkAvailability(id, qty));
    }

    @PostMapping("/reduce/{id}/{qty}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Integer id,
                                               @PathVariable int qty) {
        productService.reduceQuantity(id, qty);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/increase/{id}/{qty}")
    public ResponseEntity<Void> increaseQuantity(@PathVariable Integer id,
                                                 @PathVariable int qty) {
        productService.increaseQuantity(id, qty);
        return ResponseEntity.ok().build();
    }
}
