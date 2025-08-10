package com.wipro.rider.entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "rider")
public class Rider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "status")
	boolean status;
	
	@Column(name = "rider_id")
	String riderId;
	
	@Column(name = "vehical_req")
	String vehicalReq;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "start_point")
	String startPoint;
	
	@Column(name = "destination")
	String destination;
	
	@Column(name = "rider_amount")
	double riderAmount;
	
	@Column(name = "booking_id")
	String  bookingId;
	
}
