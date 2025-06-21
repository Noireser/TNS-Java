package com.example.placement.repository;

import com.example.placement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByNameAndPassword(String name, String password); // ✅ for login
}
