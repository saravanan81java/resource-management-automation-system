package com.resource.management.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resource.management.system.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query to find a user by username
    Optional<User> findByUsername(String username);

    // Custom query to find a user by email
    Optional<User> findByEmail(String email);

}
