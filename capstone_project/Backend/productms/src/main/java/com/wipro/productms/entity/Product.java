package com.wipro.productms.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="prod_name")
	String prodName;
	
	@Column(name="prod_desc")
	String prodDesc;
	
	@Column(name="prod_category")
	String prodCat;
	
	@Column(name="prod_make")
	String make;
	
	@Column(name="available_qty")
	int availableQty;
	
	@Column(name="price")
	double price;
	
	@Column
	String uom;
	
	@Column(name="prod_rating")
	double prodRating;
	
	@Column
	String imageURL;
	
	@Column
	LocalDate dateOfManufacture;
}