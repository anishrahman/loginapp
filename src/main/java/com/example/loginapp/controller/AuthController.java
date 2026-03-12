package com.example.loginapp.controller;

import com.example.loginapp.model.User;
import com.example.loginapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    // Show Login Page
    @GetMapping("/")
    public String showLoginPage() {
        return "login1";
    }

    // Handle Login
    @PostMapping("/login1")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {

        User user = service.checkLogin(username, password);

        if (user != null) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "login1";
        }
    }

    // Show Signup Page
    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    // Save User
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        service.registerUser(user);
        return "redirect:/";
    }

    // Home Page
    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }
}