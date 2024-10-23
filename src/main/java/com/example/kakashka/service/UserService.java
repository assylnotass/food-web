package com.example.kakashka.service;

import com.example.kakashka.model.User;
import com.example.kakashka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        try {
            userRepository.save(user);
            System.out.println("User registered successfully");
        } catch (Exception e) {
            System.out.println("Error registering user: " + e.getMessage());
        }

        // Вывод данных в консоль для проверки
        System.out.println("Registering user: " + username + ", email: " + email);

        userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
