package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")  // This maps the class to the 'course' table in the database
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "name") // Ensure this matches the column name in your DB
    private String name;

	public Course(String description, String name) {
		this.description = description;
		this.name = name;
	}
	@Column(name = "description") // Ensure this matches the column name in your DB
	private String description;

	public Course() {

	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    // Getters and Setters
}

