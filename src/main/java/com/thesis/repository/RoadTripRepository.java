package com.thesis.repository;

import com.thesis.model.RoadTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoadTripRepository extends JpaRepository<RoadTrip, Integer> {
    List<RoadTrip> getAllByUserId(Integer userId);

    @Modifying
    @Transactional
    void deleteByUserId(Integer userId);
}
