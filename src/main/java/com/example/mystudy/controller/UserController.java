package com.example.mystudy.controller;

import com.example.mystudy.domain.User;
import com.example.mystudy.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserRepository userRepository = UserRepository.getInstance();

    @GetMapping("/users/signup")
    public String signupForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "user/signupForm";
    }

    @PostMapping("/users/signup")
    public String signup(Model model,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name) {

        Long savedUserId = userRepository.save(email, password, name);
        UserForm userForm = new UserForm(email, password, name);

        model.addAttribute("userForm", userForm);

        return "user/userResult";
    }

    @GetMapping("/users/{userId}")
    public User findUser(@PathVariable Long userId) {
        return userRepository.findById(userId);
    }
}