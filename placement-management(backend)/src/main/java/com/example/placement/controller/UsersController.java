package com.example.placement.controller;

import com.example.placement.model.Users;
import com.example.placement.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public Users addUser(@RequestBody Users user) {
        return userService.addNewUser(user);
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }

    @PostMapping("/login")
    public Users login(@RequestBody Users user) {
        return userService.login(user);
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/pending")
    public List<Users> getPendingUsers() {
        return userService.getPendingUsers();
    }

    @PutMapping("/approve/{id}")
    public Users approveUser(@PathVariable Long id) {
        return userService.approveUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
