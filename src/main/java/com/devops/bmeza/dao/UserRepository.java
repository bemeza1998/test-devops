package com.devops.bmeza.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devops.bmeza.model.User;

public interface UserRepository extends MongoRepository<User, String>{

    Optional<User> findByName(String name);

} 
