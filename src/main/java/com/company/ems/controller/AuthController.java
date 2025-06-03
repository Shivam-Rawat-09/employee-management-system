package com.company.ems.controller;

import com.company.ems.dto.LoginRequest;
import com.company.ems.dto.LoginResponse;
import com.company.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.authenticateUser(loginRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        userService.logoutUser();
        return ResponseEntity.ok().build();
    }
}