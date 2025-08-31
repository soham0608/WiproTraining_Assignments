package com.wipro.productmanagement.service.impl;

import com.wipro.productmanagement.dto.ProductDTO;
import com.wipro.productmanagement.entity.Product;
import com.wipro.productmanagement.repository.ProductRepository;
import com.wipro.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // ---------- Utility Mapping Methods ----------
    private ProductDTO mapToDTO(Product product) {
        return new ProductDTO(
                product.getPid(),
                product.getProduct_name(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }

    private Product mapToEntity(ProductDTO dto) {
        return new Product(
                dto.getPid(),
                dto.getProductName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getQuantity()
        );
    }

    // ---------- CRUD ----------
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);
        return mapToDTO(productRepository.save(product));
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapToDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setProduct_name(productDTO.getProductName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return mapToDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public void delete(Integer id) { // duplicate of deleteProduct
        deleteProduct(id);
    }

    // ---------- Stock Management (used by OrderService) ----------
    @Override
    public boolean checkAvailability(Integer productId, int qty) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        return product.getQuantity() >= qty;
    }

    @Override
    public void reduceQuantity(Integer productId, int qty) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        if (product.getQuantity() < qty) {
            throw new RuntimeException("Not enough stock for product id: " + productId);
        }
        product.setQuantity(product.getQuantity() - qty);
        productRepository.save(product);
    }

    @Override
    public void increaseQuantity(Integer productId, int qty) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
        product.setQuantity(product.getQuantity() + qty);
        productRepository.save(product);
    }
}
