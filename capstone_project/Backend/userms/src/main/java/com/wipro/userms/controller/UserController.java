package com.wipro.userms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.userms.dto.Token;
import com.wipro.userms.entity.User;
import com.wipro.userms.service.UserService;

@RestController
@RequestMapping("/user")
 
public class UserController {
	@Autowired
	UserService userServie;
	
	@GetMapping
	List<User> findAll()
	{
		System.out.println("user-findAll--");
		return userServie.findAll();
	}
	
	@GetMapping("/{id}")
	User findById(@PathVariable int id)
	{
		return userServie.findById(id);
	}
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		 userServie.deleteById(id);
	}
	
	@PostMapping
	void save(@RequestBody User user)
	{
		userServie.save(user);
	}
	
	@PutMapping
	void update(@RequestBody User user)
	{
		userServie.save(user);
	}
	
	@PostMapping("/login")
	Token login(@RequestBody User user)
	{
		return userServie.login(user);
	}

}