package com.wipro.productms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.productms.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	List<Product> findByProdCatContainingIgnoreCase(String category);
    List<Product> findByProdNameContainingIgnoreCaseOrProdDescContainingIgnoreCase(String name, String description);
    List<Product> findByProdCatContainingIgnoreCaseAndProdNameContainingIgnoreCase(String category, String name);
}
