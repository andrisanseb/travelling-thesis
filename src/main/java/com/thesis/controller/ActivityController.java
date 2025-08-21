package com.thesis.controller;

import com.thesis.model.Activity;
import com.thesis.model.DTO.ActivityDTO;
import com.thesis.model.Destination;
import com.thesis.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("activities")
public class ActivityController {

    private record ActivitySingleDTO (String status, ActivityDTO data) {}
    private record ActivityListDTO (String status, List<ActivityDTO> data) {}

    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ActivitySingleDTO> createActivity(@RequestBody ActivityDTO dto) {
        Activity activity = new Activity(
                dto.getName(),
                dto.getDescription(),
                dto.getCost(),
                dto.getDuration(),
                new Destination(dto.getDestinationId()),
                dto.getCategory(),
                dto.getCreatedByUserId(),
                dto.getCreatedByUsername()
        );

        Activity savedActivity = activityRepository.save(activity);
        ActivityDTO activityDTO = modelMapper.map(savedActivity, ActivityDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ActivitySingleDTO("success", activityDTO));
    }

    // GET /activities/destinations/{destination_id}
    @GetMapping("/destinations/{destination_id}")
    public ResponseEntity<ActivityListDTO> getAllActivitiesOfThisDestination(@PathVariable int destination_id) {
        List<ActivityDTO> activities = activityRepository.findAll().stream()
                .filter(x -> x.getDestination().getId() == destination_id)
                .map(x -> modelMapper.map(x, ActivityDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ActivityListDTO("success", activities));
    }

    // GET /activities
    @GetMapping
    public ResponseEntity<ActivityListDTO> getAllActivities() {
        List<ActivityDTO> activities = activityRepository.findAll().stream()
                .map(x -> modelMapper.map(x, ActivityDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ActivityListDTO("success", activities));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ActivityListDTO> getActivitiesByUserId(@PathVariable Integer id) {
        List<ActivityDTO> activities = activityRepository.findAll().stream()
                .filter(x -> id.equals(x.getCreatedByUserId()))
                .map(x -> modelMapper.map(x, ActivityDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ActivityListDTO("success", activities));
    }

    // GET /activities/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ActivitySingleDTO> getActivityById(@PathVariable int id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        ActivityDTO activityDTO = modelMapper.map(activity, ActivityDTO.class);
        return ResponseEntity.ok(new ActivitySingleDTO("success", activityDTO));
    }

    // PUT /activities/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivityById(@PathVariable Integer id, @RequestBody ActivityDTO dto) {
        Activity activityToUpdate = activityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        activityToUpdate.setName(dto.getName());
        activityToUpdate.setDescription(dto.getDescription());
        activityToUpdate.setCost(dto.getCost());
        activityToUpdate.setDuration(dto.getDuration());
        if (dto.getDestinationId() != null) {
            activityToUpdate.setDestination(new Destination(dto.getDestinationId()));
        }
        activityToUpdate.setCategory(dto.getCategory());

        return new ResponseEntity<>(activityRepository.save(activityToUpdate), HttpStatus.CREATED);
    }

    // DELETE /activities/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Activity> deleteActivityById(@PathVariable Integer id) {
        Activity activityToDelete = activityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        activityRepository.delete(activityToDelete);
        return ResponseEntity.ok(activityToDelete);
    }
}