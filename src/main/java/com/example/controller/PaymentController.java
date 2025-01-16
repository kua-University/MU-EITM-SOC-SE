package com.example.controller;

import com.example.model.Payment;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
//@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String listPayments(Model model) {
        model.addAttribute("payments", paymentService.getAllPayments());
        return "payment-list";
    }
//    @GetMapping//testing with postman if retrives  perfact
//    public List<Payment> listPayments() {
//        return paymentService.getAllPayments();
//    }
    @GetMapping("/add")
    public String showAddPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "add-payment";
    }
//    @PostMapping //testing with postman if addeds  perfact
//    public Payment createPayment(@RequestBody Payment payment) {
//        return paymentService.addPayment(payment);
//    }
    @PostMapping("/add")
    public String addPayment(@ModelAttribute("payment") Payment payment) {
        paymentService.addPayment(payment);
        return "redirect:/payments";
    }
}
