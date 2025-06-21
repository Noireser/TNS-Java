package com.example.placement.controller;

import com.example.placement.model.Admin;
import com.example.placement.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // ✅ Add Admin
    @PostMapping("/add")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    // ✅ Update Admin
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    // ✅ Admin Login
    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return adminService.login(admin.getName(), admin.getPassword());
    }
}
