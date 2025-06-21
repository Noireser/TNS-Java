package com.example.placement.service;

import com.example.placement.model.Users;
import java.util.List;

public interface UsersService {
    Users addNewUser(Users user);
    Users updateUser(Users user);
    Users login(Users user);
    boolean logout();

    List<Users> getAllUsers();
    List<Users> getPendingUsers();
    Users approveUser(Long id);
    boolean deleteUser(Long id);
}
