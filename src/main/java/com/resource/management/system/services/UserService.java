package com.resource.management.system.services;

import java.util.List;
import java.util.Optional;

import com.resource.management.system.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	User addUser(User user);
	User updateUser(Long id, User userDetails);
	void deleteUser(Long id);
	Optional<User> findUserByUsername(String username);

}
