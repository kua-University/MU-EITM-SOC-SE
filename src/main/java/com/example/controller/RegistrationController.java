package com.example.controller;

import com.example.model.Course;
import com.example.model.Registration;
import com.example.model.User;
import com.example.service.CourseService;
import com.example.service.RegistrationService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String listRegistrations(Model model) {
        model.addAttribute("registrations", registrationService.getAllRegistrations());
        return "registration-list";
    }

    @GetMapping("/add")
    public String showAddRegistrationForm(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("registration", new Registration());
        return "add-registration";
    }

    @PostMapping("/add")
    public String addRegistration(@ModelAttribute("registration") Registration registration) {
        registrationService.addRegistration(registration);
        return "redirect:/registrations";
    }
}
