package com.example.springboot_security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
@CrossOrigin
public class AccountController {
    @GetMapping("/my-account")
    @PreAuthorize("hasAuthority('ROLE_USER')")
//    @Secured("ROLE_ADMIN")
    public String getMyAccount(){
        return "Here are the loan details.";
    }
}
