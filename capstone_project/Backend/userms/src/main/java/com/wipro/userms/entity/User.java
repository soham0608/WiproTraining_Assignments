package com.wipro.userms.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "emailid")
	String emailId;
	
	@Column(name = "user_id")
	String userId;
	
	@Column
	int phone;
	
	@Column
	String passWord;
	
	@Column
	String address;
	
	@Column
	int userType;
	
	@Column
	boolean isLoggedIn;
	
	@Column
	String salt;

}
