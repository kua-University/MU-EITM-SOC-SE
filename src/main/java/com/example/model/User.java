package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")  // Maps to the 'user' table in the database
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")  // Maps to the 'id' column
	private Long id;

	@NotEmpty
	@Column(name = "username", nullable = false)  // Maps to the 'username' column, non-null
	private String username;

	@NotEmpty
	@Column(name = "password", nullable = false)  // Maps to the 'password' column, non-null
	private String password;

	@Column(name = "role")  // Maps to the 'role' column
	private String role; // e.g., ROLE_USER or ROLE_ADMIN

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
