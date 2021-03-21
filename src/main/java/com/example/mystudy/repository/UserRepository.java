package com.example.mystudy.repository;

import com.example.mystudy.domain.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static final UserRepository userRepository = new UserRepository();
    private static Map<Long, User> userMap = new HashMap<>();
    private static long count;
    
    private UserRepository() {}

    public static UserRepository getInstance() {
        return userRepository;
    }
    
    public Long save(String email, String password, String name) {
        User savedUser = new User(count, email, password, name);
        userMap.put(count, savedUser);
        count++;

        return savedUser.getId();
    }

    public User findById(Long id) {
        return userMap.get(id);
    }
}