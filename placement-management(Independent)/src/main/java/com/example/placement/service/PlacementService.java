package com.example.placement.service;

import com.example.placement.model.Placement;

public interface PlacementService {
    Placement addPlacement(Placement placement);
    Placement updatePlacement(Placement placement);
    Placement searchPlacement(Long id);
    boolean cancelPlacement(Long id);
}
