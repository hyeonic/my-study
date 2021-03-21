package com.example.mystudy.repository;

import com.example.mystudy.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    private UserRepository userRepository = UserRepository.getInstance();

    @Test
    void saveUser() {
        
        // given
        String email = "hyeonic@email.com";
        String password = "1234";
        String name = "hyeonic";

        // when
        Long savedId = userRepository.save(email, password, name);
        User findUser = userRepository.findById(savedId);

        // then
        Assertions.assertThat(email).isEqualTo(findUser.getEmail());
        Assertions.assertThat(password).isEqualTo(findUser.getPassword());
        Assertions.assertThat(name).isEqualTo(findUser.getName());
    }

    @Test
    void findUsers() {

        // given & when
        userRepository.save(
                "hyeonic@emai.com",
                "1234",
                "hyeonic");

        userRepository.save(
                "dev@emai.com",
                "1234",
                "dev");

        // then
        Assertions.assertThat(userRepository.findUsers().size()).isEqualTo(2);
    }
}