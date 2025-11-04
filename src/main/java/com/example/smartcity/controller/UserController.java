package com.example.smartcity.controller;

import com.example.smartcity.entity.User;
import com.example.smartcity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
    private final UserService service;
    
    public UserController(UserService service) 
    	{
    		this.service = service; 
    	}

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) 
    	{         
        	return ResponseEntity.ok(service.save(user));
    	}
}
