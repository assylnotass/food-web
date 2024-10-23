package com.example.kakashka.controller;

import com.example.kakashka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Возвращаем страницу регистрации
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {
        userService.registerUser(username, email, password); // Регистрация пользователя
        model.addAttribute("message", "Registration successful!"); // Сообщение об успехе
        return "login"; // Перенаправление на страницу логина
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Возвращаем страницу логина
    }
}
