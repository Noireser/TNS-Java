package com.example.placement.repository;

import com.example.placement.model.Placement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementRepository extends JpaRepository<Placement, Long> {
}
