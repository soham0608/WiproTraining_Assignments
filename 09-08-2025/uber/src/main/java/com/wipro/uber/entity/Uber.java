package com.wipro.uber.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "uber")
public class Uber {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name = "rider_id")
	String riderId;
	
	@Column(name = "car_quantity")
	int carQuantity;
	
	@Column(name = "bike_quantity")
	int bikeQuantity;
	
	@Column(name = "amount")
	double amount;

	
}
