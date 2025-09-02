package com.wipro.productms.service;

import java.util.List;

import com.wipro.productms.entity.Product;

public interface ProductService {
	List<Product> findAll();
	Product findById(int id);
	Product save(Product product);
	void deleteById(int id);
	Product update(int id, Product product);
	
    List<Product> findByCategory(String category);
    List<Product> searchByNameOrDescription(String search);
    List<Product> searchByCategoryAndName(String category, String search);
}
