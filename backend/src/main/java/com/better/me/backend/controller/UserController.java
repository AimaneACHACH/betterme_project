package com.better.me.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.better.me.backend.model.User;
import com.better.me.backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping
	public List<User> getUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		return service.getUserByUserId(userId);
	}
	
	@GetMapping("/role/{role}")
	public List<User> getUserByRole(@PathVariable int role) {
		return service.getUserByRole(role);
	}
	
	@PutMapping
	public User modifyUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable String userId) {
		return service.deleteUser(userId);
	}
}
