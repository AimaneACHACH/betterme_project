package com.bezkoder.springjwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserByUserId(String userId) {
        return repository.findById(userId).orElse(null);
    }

    // Assuming role is stored as a string in User model
    public List<User> getUserByRole(String role) {
        return repository.findByRoles(role);
    }

    public User updateUser(String userId, User userRequest) {
        User existingUser = repository.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setRoles(userRequest.getRoles());
            existingUser.setEmail(userRequest.getEmail());
            existingUser.setPassword(userRequest.getPassword());
            return repository.save(existingUser);
        }
        return null;
    }

    public String deleteUser(String userId) {
        repository.deleteById(userId);
        return "User with Id: <" + userId + "> deleted";
    }
}
