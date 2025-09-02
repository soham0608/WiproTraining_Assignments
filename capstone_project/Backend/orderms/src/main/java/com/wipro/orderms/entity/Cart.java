package com.wipro.orderms.entity;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cart")
@Data
public class Cart {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
    
    @Column(name = "user_id", nullable = false)
    int userId;// is the login id generated for the user
    
    @ElementCollection
    @CollectionTable(name = "cart_items", 
                    joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    Map<Integer, Integer> prodDetails = new HashMap<>();
    
    int totalQty;
    Double totalPrice;
}
