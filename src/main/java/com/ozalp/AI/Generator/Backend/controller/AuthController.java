package com.ozalp.AI.Generator.Backend.controller;

import com.ozalp.AI.Generator.Backend.business.abstracts.AuthService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.UserLoginByEmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    ResponseEntity<?> register(CreateUserRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    ResponseEntity<?> login(UserLoginByEmailRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
