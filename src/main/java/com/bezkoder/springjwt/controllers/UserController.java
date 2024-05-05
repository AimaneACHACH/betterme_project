package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.service.UserService;

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
    public List<User> getUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return service.getUserByUserId(userId);
    }

    @GetMapping("/role/{role}")
    public List<User> getUserByRole(@PathVariable String role) {
        // Assuming the role is now stored as a String in User model
        return service.getUserByRole(String.valueOf(Integer.parseInt(role)));
    }

    @PutMapping("/{userId}")
    public User modifyUser(@PathVariable String userId, @RequestBody User user) {
        user.setId(userId); // Set the ID of the user
        return service.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return service.deleteUser(userId);
    }
}
