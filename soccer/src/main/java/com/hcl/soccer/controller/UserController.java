package com.hcl.soccer.controller;


import java.util.List;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.soccer.entities.User;
import com.hcl.soccer.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public User login(@RequestParam(name="email") String email, 
			@RequestParam(name="password") String password) {
		return userRepository.findByEmailAndPassword(email,password);
		
	}
	
	@GetMapping("/allusers")
	public List<User> allusers() {
		return userRepository.findAll();
		
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new RuntimeException("User Already Exists");
		}
		return userRepository.save(user);
	}
}
