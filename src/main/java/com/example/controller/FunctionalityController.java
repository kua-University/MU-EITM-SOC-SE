package com.example.controller;

import com.example.model.Course;
import com.example.model.Payment;
import com.example.model.Registration;
import com.example.model.User;
import com.example.service.CourseService;
import com.example.service.PaymentService;
import com.example.service.RegistrationService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FunctionalityController {

    // Autowire the necessary services
    @Autowired
    private CourseService courseService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

    // GET Mappings for forms
    @GetMapping("/add-course")
    public String addCourse() {
        return "add-course";
    }

    @GetMapping("/add-payment")
    public String addPayment() {
        return "add-payment";
    }

    @GetMapping("/add-registration")
    public String addRegistration() {
        return "add-registration";
    }

    @GetMapping("/add-user")
    public String addUser() {
        return "add-user";
    }

    @GetMapping("/course-list")
    public String courseList(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "course-list";
    }

    @GetMapping("/payment-list")
    public String paymentList(Model model) {
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "payment-list";
    }

    // POST Mappings to handle form submissions
    @PostMapping("/save-course")
    public String saveCourse(@RequestParam String courseName, @RequestParam String courseDescription) {
        Course course = new Course();
        course.setName(courseName);
        course.setDescription(courseDescription);
        courseService.addCourse(course); // Save course
        return "redirect:/course-list"; // Redirect after saving
    }

    @PostMapping("/save-payment")
    public String savePayment(@RequestParam double paymentAmount, @RequestParam String paymentDate, @RequestParam String studentId) {
        Payment payment = new Payment();
        payment.setAmount(paymentAmount);
        payment.setStatus("PENDING"); // Set default status
        // Add logic to link Payment with Registration/Student (if needed)
        paymentService.savePayment(payment);
        return "redirect:/payment-list";
    }

    @PostMapping("/save-registration")
    public String saveRegistration(@RequestParam Long studentId, @RequestParam Long courseId) {
        Registration registration = new Registration();
        registration.setUser(userService.getUserById(studentId)); // Fetch and set the user
        registration.setCourse(courseService.getCourseById(courseId)); // Fetch and set the course
        registrationService.saveRegistration(registration);
        return "redirect:/course-list";
    }

    @PostMapping("/save-user")
    public String saveUser(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userService.saveUser(user);
        return "redirect:/user-list";
    }
}
