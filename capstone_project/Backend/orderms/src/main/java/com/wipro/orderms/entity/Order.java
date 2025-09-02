package com.wipro.orderms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
@Data
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    
    @Column(name = "user_id", nullable = false)
    int userId;// is the login id generated for the user
    
    @ElementCollection
    @CollectionTable(name = "order_items", 
                    joinColumns = @JoinColumn(name = "order_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    Map<Integer, Integer> productQuantityMap = new HashMap<>();
    
    Double totalAmount;
    String orderStatus;
    
    @CreationTimestamp
    LocalDateTime orderDate;
}