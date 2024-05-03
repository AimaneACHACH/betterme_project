package com.better.me.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.better.me.backend.model.User;

public interface UserRepository extends MongoRepository<User,String>{

	List<User> findByRole(int role);

}
