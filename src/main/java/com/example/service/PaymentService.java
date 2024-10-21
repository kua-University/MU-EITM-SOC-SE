package com.example.service;

import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment); // Add this method to save payment
    }
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
