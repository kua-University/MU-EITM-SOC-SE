package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")  // Maps to the 'payment' table in the database
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")  // Maps to the 'id' column
    private Long id;

    @Column(name = "amount")  // Maps to the 'amount' column
    private double amount;

    @Column(name = "status")  // Maps to the 'status' column
    private String status; // e.g., PAID, PENDING, etc.

    @ManyToOne
    @JoinColumn(name = "registration_id")  // Maps to the 'registration_id' column (foreign key)
    private Registration registration;

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
