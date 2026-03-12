package com.example.loginapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.loginapp.model.User;
import com.example.loginapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public User checkLogin(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}