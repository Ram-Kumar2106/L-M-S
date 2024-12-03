package com.Learning.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";  // Renders 'index.html' from the templates folder
    }

    @GetMapping("/about")
    public String about() {
        return "about";  // Renders 'about.html' from the templates folder
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";  // Renders 'contact.html' from the templates folder
}

    @GetMapping("/course-details")
    public String courseDetails() {
        return "course-details";  // Renders 'course-details.html' from the templates folder
    }

    @GetMapping("/courses")
    public String courses() {
        return "courses";  // Renders 'courses.html' from the templates folder
    }

    @GetMapping("/events")
    public String events() {
        return "events";  // Renders 'events.html' from the templates folder
    }

    @GetMapping("/pricing")
    public String pricing() {
        return "pricing";  // Renders 'pricing.html' from the templates folder
    }

    @GetMapping("/starter-page")
    public String starterPage() {
        return "starter-page";  // Renders 'starter-page.html' from the templates folder
    }

    @GetMapping("/trainers")
    public String trainers() {
        return "trainers";  // Renders 'trainers.html' from the templates folder
    }

}



