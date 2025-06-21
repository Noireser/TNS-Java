package com.example.placement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // ✅ New field
    private int year;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = true)
    @JsonIgnoreProperties({"certificates", "students", "collegeAdmin"})
    private College college;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { // ✅ New
        return name;
    }

    public void setName(String name) { // ✅ New
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}
