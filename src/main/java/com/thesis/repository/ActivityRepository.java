package com.thesis.repository;

import com.thesis.model.Activity;
import com.thesis.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findByDestination(Destination destination);
}
