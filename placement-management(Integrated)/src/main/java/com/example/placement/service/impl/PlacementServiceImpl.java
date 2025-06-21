package com.example.placement.service.impl;

import com.example.placement.model.Placement;
import com.example.placement.repository.PlacementRepository;
import com.example.placement.service.PlacementService;
import org.springframework.stereotype.Service;

@Service
public class PlacementServiceImpl implements PlacementService {

    private final PlacementRepository placementRepository;

    public PlacementServiceImpl(PlacementRepository placementRepository) {
        this.placementRepository = placementRepository;
    }

    @Override
    public Placement addPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public Placement updatePlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public Placement searchPlacement(Long id) {
        return placementRepository.findById(id).orElse(null);
    }

    @Override
    public boolean cancelPlacement(Long id) {
        placementRepository.deleteById(id);
        return true;
    }
}
