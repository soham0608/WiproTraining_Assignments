package com.wipro.productmanagement.service.impl;

import com.wipro.productmanagement.dto.ProductDTO;
import com.wipro.productmanagement.entity.Product;
import com.wipro.productmanagement.repository.ProductRepository;
import com.wipro.productmanagement.service.ProductService;

import jakarta.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product p = toEntity(dto);
        p.setPid(null); 
        Product saved = repo.save(p);
        return toDTO(saved);
    }

    @Override
    public ProductDTO update(Integer id, ProductDTO dto) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        existing.setProduct_name(dto.getProductName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        existing.setQuantity(dto.getQuantity());

        Product saved = repo.save(existing);
        return toDTO(saved);
    }

    @Override
    public void delete(Integer id) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        repo.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO getById(Integer id) {
        return repo.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> getAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    // ------------------- New methods -------------------
    @Override
    public boolean checkAvailability(Integer productId, Integer quantity) {
        Product product = repo.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));
        return product.getQuantity() >= quantity;
    }

    @Override
    public void reduceQuantity(Integer productId, Integer quantity) {
        Product product = repo.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));

        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient quantity for product id: " + productId);
        }
        product.setQuantity(product.getQuantity() - quantity);
        repo.save(product);
    }

    @Override
    public void increaseQuantity(Integer productId, Integer quantity) {
        Product product = repo.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + productId));
        product.setQuantity(product.getQuantity() + quantity);
        repo.save(product);
    }

    // ------------------- Helper methods -------------------
    private ProductDTO toDTO(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.setPid(p.getPid());
        dto.setProductName(p.getProduct_name());
        dto.setDescription(p.getDescription());
        dto.setPrice(p.getPrice());
        dto.setQuantity(p.getQuantity());
        return dto;
    }

    private Product toEntity(ProductDTO dto) {
        Product p = new Product();
        p.setPid(dto.getPid());
        p.setProduct_name(dto.getProductName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setQuantity(dto.getQuantity());
        return p;
    }
}
