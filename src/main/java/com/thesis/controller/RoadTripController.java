package com.thesis.controller;

import com.thesis.model.DTO.RoadTripDTO;
import com.thesis.model.RoadTrip;
import com.thesis.repository.RoadTripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("roadTrips")
public class RoadTripController {

    private record RoadTripSingleDTO(String status, RoadTripDTO data) {}
    private record RoadTripListDTO(String status, List<RoadTripDTO> data) {}

    @Autowired
    RoadTripRepository roadTripRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<RoadTripSingleDTO> createRoadTrip(@RequestBody RoadTripDTO roadTripDTO) {
        RoadTrip roadTrip = modelMapper.map(roadTripDTO, RoadTrip.class);
        RoadTrip savedRoadTrip = roadTripRepository.save(roadTrip);
        RoadTripDTO savedRoadTripDTO = modelMapper.map(savedRoadTrip, RoadTripDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new RoadTripSingleDTO("success", savedRoadTripDTO));
    }

    @GetMapping
    public RoadTripListDTO getAllRoadTrips() {
        List<RoadTripDTO> dtoList = roadTripRepository.findAll().stream()
                .map(rt -> modelMapper.map(rt, RoadTripDTO.class))
                .toList();
        return new RoadTripListDTO("success", dtoList);
    }

    @GetMapping("/{id}")
    public RoadTripSingleDTO getRoadTripById(@PathVariable Integer id) {
        RoadTrip roadTrip = roadTripRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RoadTrip not found"));
        RoadTripDTO dto = modelMapper.map(roadTrip, RoadTripDTO.class);
        return new RoadTripSingleDTO("success", dto);
    }

    @GetMapping("/user/{userId}")
    public RoadTripListDTO getAllRoadTripsOfUser(@PathVariable Integer userId) {
        List<RoadTripDTO> dtoList = roadTripRepository.getAllByUserId(userId).stream()
                .map(rt -> modelMapper.map(rt, RoadTripDTO.class))
                .toList();
        return new RoadTripListDTO("success", dtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoadTripSingleDTO> updateRoadTrip(@PathVariable Integer id, @RequestBody RoadTripDTO updatedDTO) {
        RoadTrip roadTrip = roadTripRepository.findById(id).orElseThrow();

        roadTrip.setName(updatedDTO.getName());
        roadTrip.setRoute(updatedDTO.getRoute());
        roadTrip.setDays(updatedDTO.getDays());
        roadTrip.setUserId(updatedDTO.getUserId());

        RoadTrip saved = roadTripRepository.save(roadTrip);
        RoadTripDTO dto = modelMapper.map(saved, RoadTripDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RoadTripSingleDTO("success", dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoadTripSingleDTO> deleteRoadTrip(@PathVariable Integer id) {
        RoadTrip roadTrip = roadTripRepository.findById(id).orElseThrow();
        roadTripRepository.delete(roadTrip);
        RoadTripDTO dto = modelMapper.map(roadTrip, RoadTripDTO.class);
        return ResponseEntity.ok(new RoadTripSingleDTO("success", dto));
    }
}