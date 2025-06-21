package com.example.placement.service;

import com.example.placement.model.College;
import com.example.placement.model.Placement;

import java.util.List;

public interface CollegeService {
    College addCollege(College college);
    College updateCollege(College college);
    College searchCollege(Long id);
    boolean deleteCollege(Long id);
    boolean schedulePlacement(Placement placement);
    List<College> getAllColleges();
    
    // ✅ NEW
    College login(String name, String password);
}
