// NewsletterController.java
package com.Learning.lms.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {
  
    @PostMapping("/subscribe")
public String handleNewsletterSubscription(@RequestParam("email") String email) {
  // handle newsletter subscription logic here
  return "Newsletter subscription successful!";
}
}

