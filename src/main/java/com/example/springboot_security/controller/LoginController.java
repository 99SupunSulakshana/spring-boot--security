package com.example.springboot_security.controller;

import com.example.springboot_security.model.User;
import com.example.springboot_security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        ResponseEntity responseEntity = null;
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User savedUser = userRepo.save(user);
            if (savedUser.getId() != null && !savedUser.getId().isEmpty()) {
                responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("Given User Details are Successfully Registered.");
            }
        } catch (Exception ex) {
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("An Exception occurred due to "+ ex.getMessage());
        }
        return responseEntity;
    }
}
