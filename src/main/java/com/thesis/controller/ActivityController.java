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
public class ActivityController {

    private record ActivitySingleDTO (String status, ActivityDTO data) {}
    private record ActivityListDTO (String status, List<ActivityDTO> data) {}

    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    private ModelMapper modelMapper;

    //POST
    @PostMapping("destinations/{destination_id}/activities")
    public ResponseEntity<ActivitySingleDTO> createActivity(@RequestBody Activity activity, @PathVariable int destination_id) {

        Activity activityToCreate = activity;
        activityToCreate.setDestination(new Destination(destination_id));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ActivitySingleDTO("success", modelMapper
                        .map(this.activityRepository.save(activityToCreate), ActivityDTO.class)
                ));

    }

    //GET
    @GetMapping("destinations/{destination_id}/activities")
    public ResponseEntity<ActivityListDTO> getAllActivitiesOfThisDestination(@PathVariable int destination_id) {
        return ResponseEntity
                .ok(new ActivityListDTO("success", this.activityRepository.findAll().stream().filter(x -> x.getDestination().getId() == destination_id)
                        .map(x -> modelMapper
                                .map(x, ActivityDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    @GetMapping("activities")
    public ResponseEntity<ActivityListDTO> getAllActivities() {
        return ResponseEntity
                .ok(new ActivityListDTO("success", this.activityRepository.findAll().stream()
                        .map(x -> modelMapper
                                .map(x, ActivityDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    @GetMapping("activities/free")
    public ResponseEntity<ActivityListDTO> getAllFreeActivities() {
        return ResponseEntity
                .ok(new ActivityListDTO("success", this.activityRepository.findAll().stream().filter(x -> x.getCost() == 0)
                        .map(x -> modelMapper
                                .map(x, ActivityDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    @GetMapping("activities/{id}")
    public ResponseEntity<ActivitySingleDTO> getActivityById(@PathVariable int id) {
        return ResponseEntity
                .ok(new ActivitySingleDTO("success", this.activityRepository.findById(id)
                        .map(x -> modelMapper
                                .map(x, ActivityDTO.class)).orElseThrow()
                ));
    }



    //UPDATE
    @PutMapping("activities/{id}")
    public ResponseEntity<Activity> updateActivityById(@PathVariable Integer id, @RequestBody Activity activity) {
        Activity activityToUpdate = this.activityRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        activityToUpdate.setName(activity.getName());
        activityToUpdate.setDescription(activity.getDescription());
        activityToUpdate.setCost(activity.getCost());

        return new ResponseEntity<Activity>(this.activityRepository.save(activityToUpdate), HttpStatus.CREATED);
    }


    //DELETE
    @DeleteMapping("activities/{id}")
    public ResponseEntity<Activity> deleteActivityById(@PathVariable Integer id) {
        Activity activityToDelete = this.activityRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        this.activityRepository.delete(activityToDelete);
        return ResponseEntity.ok(activityToDelete);
    }

}
