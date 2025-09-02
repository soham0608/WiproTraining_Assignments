package com.wipro.productms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.productms.entity.Product;
import com.wipro.productms.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	List<Product> findAll()
	{
		return productService.findAll();
	}
	@GetMapping("/{id}")
	Product findById(@PathVariable int id)
	{
		return productService.findById(id);
	}
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		productService.deleteById(id);
	}
	@PostMapping
	Product save(@RequestBody Product product)
	{
		return productService.save(product);
	}
	@PutMapping("/{id}")
	void update(@RequestBody Product product)
	{
		productService.save(product);
		
	}
	
	@GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search) {
        
        List<Product> products;
        try {
            if (category != null && search != null) {
                products = productService.searchByCategoryAndName(category, search);
            } else if (category != null) {
                products = productService.findByCategory(category);
            } else if (search != null) {
                products = productService.searchByNameOrDescription(search);
            } else {
                products = productService.findAll();
            }
            
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}