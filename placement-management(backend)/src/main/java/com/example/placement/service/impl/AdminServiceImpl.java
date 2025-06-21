package com.example.placement.service.impl;

import com.example.placement.model.Admin;
import com.example.placement.repository.AdminRepository;
import com.example.placement.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(String name, String password) {
        return adminRepository.findByNameAndPassword(name, password);
    }
}
