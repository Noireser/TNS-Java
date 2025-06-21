package com.example.placement.controller;

import com.example.placement.model.Placement;
import com.example.placement.service.PlacementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/placements")
public class PlacementController {

    private final PlacementService placementService;

    public PlacementController(PlacementService placementService) {
        this.placementService = placementService;
    }

    @PostMapping("/add")
    public Placement addPlacement(@RequestBody Placement placement) {
        return placementService.addPlacement(placement);
    }

    @PutMapping("/update")
    public Placement updatePlacement(@RequestBody Placement placement) {
        return placementService.updatePlacement(placement);
    }

    @GetMapping("/search/{id}")
    public Placement getPlacement(@PathVariable Long id) {
        return placementService.searchPlacement(id);
    }

    @DeleteMapping("/cancel/{id}")
    public boolean cancelPlacement(@PathVariable Long id) {
        return placementService.cancelPlacement(id);
    }

    // ✅ NEW: Get all placements
    @GetMapping("/all")
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }
}
