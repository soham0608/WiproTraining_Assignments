package com.wipro.productms.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Data
public class Order {
	
    int orderId;
    
    int userId; // is the login id generated for the user
    
    
    Map<Integer, Integer> productQuantityMap = new HashMap<>();
    
    Double totalAmount;
    String orderStatus; 
    
    LocalDateTime orderDate;
}