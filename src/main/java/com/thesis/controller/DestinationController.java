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
import java.util.List;

@RestController
@RequestMapping("destinations")
public class DestinationController {

    private record DestinationSingleDTO(String status, DestinationDTO data) {}
    private record DestinationListDTO(String status, List<DestinationDTO> data) {}

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<DestinationSingleDTO> createDestination(@RequestBody Destination destination) {
        destinationRepository.save(destination);

        DestinationDTO dto = modelMapper.map(destination, DestinationDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new DestinationSingleDTO("success", dto));
    }

    @GetMapping
    public DestinationListDTO getAllDestinations() {
        List<Destination> destinations = destinationRepository.findAll();

        List<DestinationDTO> dtoList = destinations.stream()
                .map(destination -> modelMapper.map(destination, DestinationDTO.class))
                .toList();

        return new DestinationListDTO("success", dtoList);
    }

    @GetMapping("/{id}")
    public DestinationSingleDTO getDestinationById(@PathVariable("id") Integer id) {
        Destination destination = destinationRepository.findById(id).orElseThrow();

        DestinationDTO dto = modelMapper.map(destination, DestinationDTO.class);
        return new DestinationSingleDTO("success", dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationSingleDTO> updateDestination(@PathVariable Integer id, @RequestBody Destination updated) {
        Destination destination = destinationRepository.findById(id).orElseThrow();

        destination.setName(updated.getName());
        destination.setDescription(updated.getDescription());
        destination.setImg_path(updated.getImg_path());
        destination.setCountry(updated.getCountry());

        destinationRepository.save(destination);

        DestinationDTO dto = modelMapper.map(destination, DestinationDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DestinationSingleDTO("success", dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DestinationSingleDTO> deleteDestination(@PathVariable Integer id) {
        Destination destination = destinationRepository.findById(id).orElseThrow();
        destinationRepository.delete(destination);

        DestinationDTO dto = modelMapper.map(destination, DestinationDTO.class);
        return ResponseEntity.ok(new DestinationSingleDTO("success", dto));
    }
}
