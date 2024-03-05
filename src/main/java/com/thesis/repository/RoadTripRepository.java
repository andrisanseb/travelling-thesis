package com.thesis.repository;

import com.thesis.model.RoadTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadTripRepository extends JpaRepository<RoadTrip, Integer> {
}
