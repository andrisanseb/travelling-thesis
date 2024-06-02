package com.thesis.controller;

import com.thesis.model.DTO.FavoriteActivityDTO;
import com.thesis.model.FavoriteActivity;
import com.thesis.repository.ActivityRepository;
import com.thesis.repository.FavoriteActivityRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("favoriteActivities")
public class FavoriteActivityController {

    @Autowired
    private FavoriteActivityRepository favoriteActivityRepository;

    @Autowired
    private ActivityRepository activityRepository;


    @PostMapping
    public ResponseEntity<String> addFavoriteActivity(@RequestBody FavoriteActivityDTO favoriteActivityDTO) {
        FavoriteActivity favoriteActivity = new FavoriteActivity(favoriteActivityDTO.getUserId(), favoriteActivityDTO.getActivityId());
        favoriteActivityRepository.save(favoriteActivity);
        return ResponseEntity.ok("Activity added to favorites successfully");
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFavoriteActivity(@RequestBody FavoriteActivityDTO favoriteActivityDTO) {
        favoriteActivityRepository.deleteByUserIdAndActivityId(favoriteActivityDTO.getUserId(), favoriteActivityDTO.getActivityId());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public List<Integer> getFavoritesByUserId(@PathVariable Integer userId) {
        List<FavoriteActivity> favoriteActivities = favoriteActivityRepository.findByUserId(userId);
        List<Integer> activityIds = favoriteActivities.stream().map(FavoriteActivity::getActivityId).collect(Collectors.toList());
//        List<Activity> activities = activityRepository.findByIdIn(activityIds);
        return activityIds;
    }


    @GetMapping
    public ResponseEntity<List<FavoriteActivity>> getAllFavoriteActivities() {
        return ResponseEntity.ok(this.favoriteActivityRepository.findAll());
    }

}
