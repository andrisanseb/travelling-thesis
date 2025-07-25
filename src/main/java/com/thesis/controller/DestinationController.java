package com.thesis.controller;

import com.thesis.model.DTO.DestinationDTO;
import com.thesis.model.Destination;
import com.thesis.repository.ActivityRepository;
import com.thesis.repository.DestinationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("destinations")
public class DestinationController {

    private record DestinationSingleDTO (String status, DestinationDTO data) {}
    private record DestinationListDTO (String status, List<DestinationDTO> data) {}

    @Autowired
    DestinationRepository destinationRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<DestinationSingleDTO> createDestination(@RequestBody Destination destination) {

        this.destinationRepository.save(destination);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new DestinationSingleDTO("success", modelMapper
                        .map(destination, DestinationDTO.class)
                ));
    }

    @GetMapping
    public List<Destination> getAllDestinations() {
        return this.destinationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable("id") Integer id) {
        return this.destinationRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable Integer id, @RequestBody Destination destination) {
        Destination destinationToUpdate = this.destinationRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        destinationToUpdate.setName(destination.getName());
        destinationToUpdate.setDescription(destination.getDescription());
        destinationToUpdate.setImg_path(destination.getImg_path());

        return new ResponseEntity<Destination>(this.destinationRepository.save(destinationToUpdate), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Destination> deleteDestination(@PathVariable Integer id) {
        Destination destinationToDelete = this.destinationRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        this.destinationRepository.delete(destinationToDelete);
        return ResponseEntity.ok(destinationToDelete);
    }
}
