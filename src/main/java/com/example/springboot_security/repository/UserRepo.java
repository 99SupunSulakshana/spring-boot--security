package com.example.springboot_security.repository;

import com.example.springboot_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    List<User> findByEmail(String username);
}
