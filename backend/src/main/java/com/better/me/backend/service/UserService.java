package com.better.me.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.better.me.backend.model.User;
import com.better.me.backend.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	//CRUD CREATE , READ , UPDATE , DELETE
	
	public User addUser(User user){
		user.setUserId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(user);
	}
	
	public List<User> findAllUsers(){
		return repository.findAll();
	}
	
	public User getUserByUserId(String userId) {
		return repository.findById(userId).get();
	}
	
	public List<User> getUserByRole(int role) {
		return repository.findByRole(role);
	}
	
	public User updateUser(User userRequest) {
		// get existing doc from DB and populate it from request
		User existingUser = repository.findById(userRequest.getUserId()).get();
		existingUser.setRole(userRequest.getRole());
		existingUser.setEmail(userRequest.getEmail());
		existingUser.setPassword(userRequest.getPassword());
		return repository.save(existingUser);
	}
	
	public String deleteUser(String userId) {
		repository.deleteById(userId);
		return "User with Id: <" + userId + "> deleted";
	}
}
