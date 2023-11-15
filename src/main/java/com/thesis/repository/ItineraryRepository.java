package com.thesis.repository;

import com.thesis.model.Itinerary;
import com.thesis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {
    List<Itinerary> findByUser(User user);
}
