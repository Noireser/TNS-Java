package com.example.placement.repository;

import com.example.placement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
}
