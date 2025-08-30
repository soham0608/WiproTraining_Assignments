package com.wipro.productmanagement.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(name = "product_name" , nullable = false)
	private String product_name;
	
	@Column(name = "description")
	private String description;
	
	@Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal  price;
	
	@Column(nullable = false)
    private Integer quantity;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal  getPrice() {
		return price;
	}

	public void setPrice(BigDecimal  price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product(Integer pid, String product_name, String description, BigDecimal price, Integer quantity) {
		super();
		this.pid = pid;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}
