package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registration")  // Maps to the 'registration' table in the database
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")  // Maps to the 'id' column
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")  // Maps to the 'user_id' column (foreign key)
	private User user;

	@ManyToOne
	@JoinColumn(name = "course_id")  // Maps to the 'course_id' column (foreign key)
	private Course course;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
