package com.example.placement.model;

import javax.persistence.*;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collegeName;
    private String location;

    @OneToOne
    private Users collegeAdmin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Users getCollegeAdmin() {
		return collegeAdmin;
	}

	public void setCollegeAdmin(Users collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}

    // Getters and Setters
}
