package com.example.mystudy.controller;

import com.example.mystudy.domain.User;
import com.example.mystudy.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository = UserRepository.getInstance();

    @PostMapping("/users")
    public User signup(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name) {
        Long savedUserId = userRepository.save(email, password, name);

        return userRepository.findById(savedUserId);
    }

    @GetMapping("/users/{userId}")
    public User findUser(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }
}