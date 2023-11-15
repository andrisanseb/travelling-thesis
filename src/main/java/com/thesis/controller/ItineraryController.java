package com.thesis.controller;

import com.thesis.model.Activity;
import com.thesis.model.DTO.ActivityDTO;
import com.thesis.model.DTO.ItineraryDTO;
import com.thesis.model.Itinerary;
import com.thesis.model.User;
import com.thesis.repository.ActivityRepository;
import com.thesis.repository.DestinationRepository;
import com.thesis.repository.ItineraryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users/{user_id}/itineraries")
public class ItineraryController {

    private record ItinerarySingleDTO (String status, ItineraryDTO data) {}
    private record ItineraryListDTO (String status, List<ItineraryDTO> data) {}

    private record ActivitySingleDTO (String status, ActivityDTO data) {}

    @Autowired
    ItineraryRepository itineraryRepository;
    @Autowired
    DestinationRepository destinationRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Extra Method
    public void total_cost_updater () {
        //update total costs
        for (Itinerary itinerary: this.itineraryRepository.findAll()) {
            itinerary.setTotal_cost(itinerary.calculateTotalCost());
        }
    }


    //ENDPOINTS

    //POST
    @PostMapping
    public ResponseEntity<ItinerarySingleDTO> createItinerary(@RequestBody Itinerary itinerary, @PathVariable int user_id) {

        Itinerary itineraryToCreate = itinerary;
        itineraryToCreate.setUser(new User(user_id));
        itineraryToCreate.setDestination(this.destinationRepository.findById(itinerary.getDestination().getId()).orElseThrow());


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ItinerarySingleDTO("success", modelMapper
                        .map(this.itineraryRepository.save(itineraryToCreate), ItineraryDTO.class)
                ));
    }

    @PostMapping("/{id}/activities")
    public ResponseEntity<ItinerarySingleDTO> addActivityToItinerary(@RequestBody Integer activity_id, @PathVariable Integer user_id, @PathVariable Integer id) {

        Activity activityToAdd = this.activityRepository.findById(activity_id).orElseThrow();
        Itinerary itinerary = this.itineraryRepository.findById(id).orElseThrow();

        //If the activity we try to add, does not link to the destination of the itinerary, return error
        if (activityToAdd.getDestination().getId() != itinerary.getDestination().getId()) {
            System.out.println("Please choose an activity of the correct destination");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }

        //Check so an itinerary will not have duplicate activities
        if (itinerary.getActivities().contains(activityToAdd)) {
            System.out.println("Activity already in added to this itinerary");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        } else {
            itinerary.getActivities().add(activityToAdd);
            itinerary.setTotal_cost(itinerary.calculateTotalCost());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ItinerarySingleDTO("success", modelMapper
                        .map(this.itineraryRepository.save(itinerary), ItineraryDTO.class)
                ));
    }



    //GET
    @GetMapping
    public ResponseEntity<ItineraryListDTO> getAllItinerariesOfUser(@PathVariable int user_id) {
        total_cost_updater();
        return ResponseEntity
                .ok(new ItineraryListDTO("success", this.itineraryRepository.findAll().stream()
                        .filter(x -> x.getUser().getId() == user_id)
                        .map(x -> modelMapper
                                .map(x, ItineraryDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItinerarySingleDTO> getItineraryById(@PathVariable int id, @PathVariable Integer user_id) {
        Itinerary itinerary = this.itineraryRepository.findById(id).orElseThrow();

        //cannot see itinerary if it belongs to other user
        if (itinerary.getUser().getId() != user_id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        total_cost_updater();


        return ResponseEntity
                .ok(new ItinerarySingleDTO("success", this.itineraryRepository.findById(id)
                        .map(x -> modelMapper
                        .map(x, ItineraryDTO.class)).orElseThrow()
                ));
    }

    @GetMapping("/public")
    public ResponseEntity<ItineraryListDTO> getAllPublicItinerariesOfOtherUsers(@PathVariable int user_id) {
        total_cost_updater();
        return ResponseEntity
                .ok(new ItineraryListDTO("success", this.itineraryRepository.findAll().stream()
                        .filter(x -> x.getUser().getId() != user_id && x.isIs_public())
                        .map(x -> modelMapper
                                .map(x, ItineraryDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    @GetMapping("/{id}/activities")
    public ResponseEntity<List<Activity>> getAllActivitiesOfThisItinerary(@PathVariable int id, @PathVariable int user_id) {
        Itinerary itineraryFound = this.itineraryRepository.findById(id).orElseThrow();

        List<Activity> activities = this.itineraryRepository.findById(id).get().getActivities();

        if (itineraryFound.isIs_public() || itineraryFound.getUser().getId() == user_id) {
            activities = itineraryFound.getActivities();
        }
        return ResponseEntity.ok(activities);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ItinerarySingleDTO> updateItinerary(@PathVariable Integer id, @RequestBody Itinerary itinerary) {
        Itinerary itineraryToUpdate = this.itineraryRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        itineraryToUpdate.setName(itinerary.getName());
        itineraryToUpdate.setTotal_days(itinerary.getTotal_days());
        itineraryToUpdate.setIs_public(itinerary.isIs_public());
        //when destination changes
        if (itineraryToUpdate.getDestination().getId() != itinerary.getDestination().getId()) {
            itineraryToUpdate.getActivities().clear();
            itineraryToUpdate.setTotal_cost(0);
            itineraryToUpdate.setDestination(this.destinationRepository.findById(itinerary.getDestination().getId()).orElseThrow());
        }
        this.itineraryRepository.save(itineraryToUpdate);

        return ResponseEntity
                .ok(new ItinerarySingleDTO("success", this.itineraryRepository.findById(id)
                        .map(x -> modelMapper
                                .map(x, ItineraryDTO.class)).orElseThrow()
                ));
    }


    @PutMapping("/{id}/activities")
    public ResponseEntity<ActivitySingleDTO> removeActivityFromItinerary(@RequestBody Integer activity_id, @PathVariable Integer user_id, @PathVariable Integer id) {
        Itinerary itinerary = this.itineraryRepository.findById(id).orElseThrow();

        //cannot make changes if itinerary belongs to other user
        if (itinerary.getUser().getId() != user_id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Activity activityToRemove = this.activityRepository.findById(activity_id).orElseThrow();

        if (!itinerary.getActivities().contains(activityToRemove)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        List<Activity> oldActivities = itinerary.getActivities();
        itinerary.getActivities().remove(activityToRemove);
        itinerary.setActivities(itinerary.getActivities());
        this.itineraryRepository.save(itinerary);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ActivitySingleDTO("success", modelMapper
                        .map(activityToRemove, ActivityDTO.class)
                ));
    }


    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Itinerary> deleteItineraryOfUserById(@PathVariable Integer id, @PathVariable Integer user_id) {
        Itinerary itineraryToDelete = this.itineraryRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        //cannot delete itinerary if it belongs to other user
        if (itineraryToDelete.getUser().getId() != user_id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        this.itineraryRepository.delete(itineraryToDelete);
        return ResponseEntity.ok(itineraryToDelete);
    }
}
