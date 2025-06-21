package com.example.placement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int roll;
    private String qualification;
    private String course;
    private int year;
    private Long hallTicketNo;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = true)
    @JsonIgnoreProperties({"students", "certificates", "collegeAdmin"}) // Avoid circular ref
    private College college;

    @OneToOne
    @JoinColumn(name = "certificate_id", nullable = true)
    @JsonIgnoreProperties({"college"}) // Avoid circular ref
    private Certificate certificate;

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

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Long getHallTicketNo() {
		return hallTicketNo;
	}

	public void setHallTicketNo(Long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

    // Getters and Setters
    // (Generate them all)
}
