package com.example.placement.service;

import com.example.placement.model.Placement;
import java.util.List;

public interface PlacementService {
    Placement addPlacement(Placement placement);
    Placement updatePlacement(Placement placement);
    Placement searchPlacement(Long id);
    boolean cancelPlacement(Long id);

    // ✅ New method
    List<Placement> getAllPlacements();
}
