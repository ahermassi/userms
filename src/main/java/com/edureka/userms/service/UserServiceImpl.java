package com.edureka.userms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edureka.userms.controller.UserController;
import com.edureka.userms.model.User;
import com.edureka.userms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository userRepository;
	private final RestTemplate restTemplate;
	
	@Value("${orderms.url}")
	private String ordermsUrl;
	
	public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		LOGGER.info("**** UserServiceImpl - getting all users ****");
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getSingleUser(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public void createUser(User user) {
//		userRepository.save(user);

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void partiallyUpdateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getAllOrders() {
		return restTemplate.getForObject(ordermsUrl, Object.class);
	}
	
	


}
