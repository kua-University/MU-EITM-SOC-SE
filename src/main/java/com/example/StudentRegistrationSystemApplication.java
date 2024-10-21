package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.model")
public class StudentRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationSystemApplication.class, args);
	}

}
