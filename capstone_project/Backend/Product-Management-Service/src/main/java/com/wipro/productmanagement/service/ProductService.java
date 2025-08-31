package com.wipro.productmanagement.service;

import com.wipro.productmanagement.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(Integer id);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(Integer id, ProductDTO productDTO);

    void deleteProduct(Integer id);

    boolean checkAvailability(Integer productId, int qty);

    void reduceQuantity(Integer productId, int qty);

    void increaseQuantity(Integer productId, int qty);

	void delete(Integer id);
}
