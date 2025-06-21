package com.example.placement.service.impl;

import com.example.placement.model.Users;
import com.example.placement.repository.UserRepository;
import com.example.placement.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users addNewUser(Users user) {
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
}
