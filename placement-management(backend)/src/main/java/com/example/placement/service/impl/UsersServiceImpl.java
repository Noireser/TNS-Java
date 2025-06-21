package com.example.placement.service.impl;

import com.example.placement.model.Users;
import com.example.placement.repository.UsersRepository;
import com.example.placement.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;

    public UsersServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users addNewUser(Users user) {
        user.setApproved(false);
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users login(Users user) {
        return userRepository.findByName(user.getName());
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> getPendingUsers() {
        return userRepository.findByApprovedFalse();
    }

    @Override
    public Users approveUser(Long id) {
        Users user = userRepository.findById(id).orElseThrow();
        user.setApproved(true);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
