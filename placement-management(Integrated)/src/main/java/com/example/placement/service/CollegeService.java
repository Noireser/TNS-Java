package com.example.placement.service;

import com.example.placement.model.College;
import com.example.placement.model.Placement;

public interface CollegeService {
    College addCollege(College college);
    College updateCollege(College college);
    College searchCollege(Long id);
    boolean deleteCollege(Long id);
    boolean schedulePlacement(Placement placement);
}
