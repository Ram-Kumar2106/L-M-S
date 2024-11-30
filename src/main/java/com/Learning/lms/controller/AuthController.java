package com.Learning.lms.controller;

import com.Learning.lms.model.User;
import com.Learning.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Display login page
    @GetMapping("/login")
    public String login() {
        return "login"; // Returns login.html
    }

    // Display signup page
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // Returns signup.html
    }

    // Handle signup logic
    @PostMapping("/signup")
public String register(@ModelAttribute("user") User user, Model model) {
    try {
        userService.registerUser(user);
        return "redirect:/login?registered=true";
    } catch (Exception e) {
        model.addAttribute("error", "Registration failed: " + e.getMessage());
        return "signup";
    }
}


}
