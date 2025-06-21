package com.example.placement.service.impl;

import com.example.placement.model.College;
import com.example.placement.model.Placement;
import com.example.placement.repository.CollegeRepository;
import com.example.placement.repository.PlacementRepository;
import com.example.placement.service.CollegeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository collegeRepository;
    private final PlacementRepository placementRepository;

    public CollegeServiceImpl(CollegeRepository collegeRepository, PlacementRepository placementRepository) {
        this.collegeRepository = collegeRepository;
        this.placementRepository = placementRepository;
    }

    @Override
    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public College updateCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public College searchCollege(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCollege(Long id) {
        collegeRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean schedulePlacement(Placement placement) {
        placementRepository.save(placement);
        return true;
    }

    @Override
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    // ✅ NEW
    @Override
    public College login(String name, String password) {
        College college = collegeRepository.findByCollegeNameAndPassword(name, password);
        if (college != null && college.isApproved()) {
            return college;
        }
        return null;
    }
}
