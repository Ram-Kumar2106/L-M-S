package com.Learning.lms.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
  
    @PostMapping("/contact")
public String handleContactFormSubmission(@RequestParam("name") String name, 
                                         @RequestParam("email") String email, 
                                         @RequestParam("subject") String subject, 
                                         @RequestParam("message") String message, 
                                         Model model) {
  // Process the form data here
  // ...
  
  // Return a success message to the view
  model.addAttribute("successMessage", "Your message has been sent. Thank you!");
  return "contact";
}
}