package com.example.placement.controller;

import com.example.placement.model.College;
import com.example.placement.model.Placement;
import com.example.placement.service.CollegeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping("/add")
    public College addCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }

    @PutMapping("/update")
    public College updateCollege(@RequestBody College college) {
        return collegeService.updateCollege(college);
    }

    @GetMapping("/search/{id}")
    public College getCollege(@PathVariable Long id) {
        return collegeService.searchCollege(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCollege(@PathVariable Long id) {
        return collegeService.deleteCollege(id);
    }

    @PostMapping("/schedule")
    public boolean schedulePlacement(@RequestBody Placement placement) {
        return collegeService.schedulePlacement(placement);
    }

    @GetMapping("/all")
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // ✅ NEW: Login
    @PostMapping("/login")
    public College login(@RequestBody College loginData) {
        return collegeService.login(loginData.getCollegeName(), loginData.getPassword());
    }
}
