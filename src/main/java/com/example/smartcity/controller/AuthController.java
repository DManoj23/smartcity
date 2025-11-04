package com.example.smartcity.controller;

import com.example.smartcity.dto.LoginRequest;
import com.example.smartcity.dto.LoginResponse;
import com.example.smartcity.entity.User;
import com.example.smartcity.service.UserService;
import com.example.smartcity.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        return userService.findByUsername(req.getUsername())
            .map(u -> {
                System.out.println("Found user: " + u.getUsername());
                System.out.println("DB Password: " + u.getPassword());
                System.out.println("Input Password: " + req.getPassword());

                if (u.getPassword().equals(req.getPassword())) {
                    String token = jwtUtil.generateToken(u.getUsername());
                    return ResponseEntity.ok(new LoginResponse(token));
                } else {
                    System.out.println("Invalid password for user: " + u.getUsername());
                    return ResponseEntity.status(401).body("Invalid password");
                }
            })
            .orElseGet(() -> {
                System.out.println("User not found: " + req.getUsername());
                return ResponseEntity.status(404).body("User not found");
            });
    }
}
