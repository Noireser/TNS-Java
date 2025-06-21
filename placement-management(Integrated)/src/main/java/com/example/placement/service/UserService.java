package com.example.placement.service;

import com.example.placement.model.Users;

public interface UserService {
    Users addNewUser(Users user);
    Users updateUser(Users user);
    Users login(Users user);
    boolean logout(); // For now, just return true
}
