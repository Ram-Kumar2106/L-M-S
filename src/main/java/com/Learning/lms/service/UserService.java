package com.Learning.lms.service;

import com.Learning.lms.model.User;
import com.Learning.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
private PasswordEncoder passwordEncoder;

public void registerUser(User user) {
    if (user.getPassword().length() < 8) {
        throw new IllegalArgumentException("Password must be at least 8 characters long");
    }
    // Add more password validation rules as needed
    
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    // rest of your registration logic
}


public boolean verifyUser(String username, String password) {
    return userRepository.findByUsername(username)
            .map(user -> passwordEncoder.matches(password, user.getPassword()))
            .orElse(false);
  }
}