package com.wipro.productms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.productms.entity.Product;
import com.wipro.productms.repo.ProductRepo;
import com.wipro.productms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Product findById(int id) {
		Optional<Product> foodOpt= productRepo.findById(id);
		if(foodOpt.isPresent())
		{
			return foodOpt.get();
		}
		return null;
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	@Override
	public Product update(int id, Product product) {
	    return productRepo.findById(id).map(existingProduct -> {
	        
	        existingProduct.setProdName(product.getProdName());
	        existingProduct.setProdDesc(product.getProdDesc());
	        existingProduct.setProdCat(product.getProdCat());
	        existingProduct.setMake(product.getMake());
	        existingProduct.setAvailableQty(product.getAvailableQty());
	        existingProduct.setPrice(product.getPrice());
	        existingProduct.setUom(product.getUom());
	        existingProduct.setProdRating(product.getProdRating());
	        existingProduct.setImageURL(product.getImageURL());
	        existingProduct.setDateOfManufacture(product.getDateOfManufacture());

	        return productRepo.save(existingProduct);
	    }).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}

	@Override
	public void deleteById(int id) {

		productRepo.deleteById(id);
	}
	
	@Override
    public List<Product> findByCategory(String category) {
        return productRepo.findByProdCatContainingIgnoreCase(category);
    }

    @Override
    public List<Product> searchByNameOrDescription(String search) {
        return productRepo.findByProdNameContainingIgnoreCaseOrProdDescContainingIgnoreCase(search, search);
    }

    @Override
    public List<Product> searchByCategoryAndName(String category, String search) {
        return productRepo.findByProdCatContainingIgnoreCaseAndProdNameContainingIgnoreCase(category, search);
    }
}
