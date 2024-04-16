package com.example.jpa.auth.controller;

import com.example.jpa.auth.dto.response.UserResponse;
import com.example.jpa.auth.service.AuthService;
import com.example.jpa.auth.service.AuthServiceImpl;
import com.example.jpa.global.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @GetMapping
    public List<UserResponse> getAll(){
        return authService.getAll();
    }
    @PostMapping
    public void save(){
        Map<String,String> map = new HashMap<>();
        map.put("username", "name");
        map.put("nickname", "nickname");
        map.put("password", "password");
        authService.save(map);
    }

}

