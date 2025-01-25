package com.resource.management.system.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.resource.management.system.model.User;
import com.resource.management.system.repository.UserRepository;
import com.resource.management.system.services.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add a new user
    public User addUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    // Update an existing user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    // Delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find user by username
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
