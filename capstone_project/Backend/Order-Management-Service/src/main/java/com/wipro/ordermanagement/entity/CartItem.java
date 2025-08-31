package com.wipro.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "product_id", nullable = false)
    private Integer product_id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = true, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "product_name")
    private String product_name;

	public Integer getCart_id() {
		return cart_id;
	}

	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public CartItem(Integer cart_id, Integer user_id, Integer product_id, Integer quantity, BigDecimal price,
			String product_name) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.product_name = product_name;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
