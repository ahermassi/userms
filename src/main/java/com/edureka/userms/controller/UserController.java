package com.edureka.userms.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.userms.model.User;
import com.edureka.userms.service.UserService;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private final UserService userService;
	
	// TDD recommends to use constructor injection
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public ResponseEntity getAllUsers() {
		LOGGER.info("**** UserResource - getting all users ****");
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity getSingleUser(@PathVariable Long userId) {
		LOGGER.info("**** UserResource - getting single user ****");
		Optional<User> singleUser = userService.getSingleUser(userId);
		
		if (singleUser.isPresent()) {
			return ResponseEntity.ok(singleUser.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/allOrders")
	public Object getAllOrders() {
		return userService.getAllOrders();
	}

}
