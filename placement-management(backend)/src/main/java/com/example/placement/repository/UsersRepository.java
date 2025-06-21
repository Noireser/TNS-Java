package com.example.placement.repository;

import com.example.placement.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByName(String name);
    List<Users> findByApprovedFalse();
    List<Users> findByTypeAndApproved(String type, boolean approved);
}
