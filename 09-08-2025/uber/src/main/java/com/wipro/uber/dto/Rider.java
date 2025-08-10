package com.wipro.uber.dto;

import lombok.Data;

@Data
public class Rider {
	
	int id;
	String riderId;
	boolean status;
	String vehicalReq;
	int quantity;
	String startPoint;
	String destination;
	double riderAmount;
	String bookingId;

}
