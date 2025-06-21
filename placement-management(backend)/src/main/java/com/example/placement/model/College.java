package com.example.placement.model;

import javax.persistence.*;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collegeName;
    private String location;
    private String password;

    @Column(nullable = false)
    private boolean approved = false;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCollegeName() { return collegeName; }
    public void setCollegeName(String collegeName) { this.collegeName = collegeName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
