package com.thesis.controller;

import com.thesis.model.DTO.ActivityDTO;
import com.thesis.model.DTO.RoadTripDTO;
import com.thesis.model.RoadTrip;
import com.thesis.model.User;
import com.thesis.repository.ActivityRepository;
import com.thesis.repository.DestinationRepository;
import com.thesis.repository.RoadTripRepository;
import com.thesis.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("roadTrip")
public class RoadTripController {

    private record RoadTripSingleDTO (String status, RoadTripDTO data) {}
    private record RoadTripListDTO (String status, List<RoadTripDTO> data) {}
    private record ActivitySingleDTO (String status, ActivityDTO data) {}

    @Autowired
    RoadTripRepository roadTripRepository;
    @Autowired
    DestinationRepository destinationRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<RoadTripSingleDTO> createRoadTrip(@RequestBody RoadTrip roadTrip) {

        RoadTrip roadTripToCreate = roadTrip;

        return ResponseEntity
                .ok(new RoadTripSingleDTO("success", modelMapper
                        .map(this.roadTripRepository.save(roadTripToCreate), RoadTripDTO.class)
  ));
    }


    @GetMapping
    public ResponseEntity<RoadTripListDTO> getAllRoadTrips() {
        return ResponseEntity
                .ok(new RoadTripListDTO("success", this.roadTripRepository.findAll().stream()
                        .map(x -> modelMapper
                                .map(x, RoadTripDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    // TODO: get by id, getAll of user_id, update, delete enpoints
}
