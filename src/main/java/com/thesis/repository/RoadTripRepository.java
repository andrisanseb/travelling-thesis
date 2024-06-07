package com.thesis.repository;

import com.thesis.model.Activity;
import com.thesis.model.RoadTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadTripRepository extends JpaRepository<RoadTrip, Integer> {
    List<RoadTrip> getAllByUserId(Integer userId);

}
