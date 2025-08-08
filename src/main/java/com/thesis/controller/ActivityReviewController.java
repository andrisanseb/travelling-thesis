package com.thesis.controller;

import com.thesis.model.ActivityReview;
import com.thesis.model.DTO.ActivityReviewDTO;
import com.thesis.repository.ActivityReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("activityReviews")
public class ActivityReviewController {

    @Autowired
    private ActivityReviewRepository activityReviewRepository;

    @PostMapping
    public ResponseEntity<String> addActivityReview(@RequestBody ActivityReviewDTO dto) {
        if (dto.getStars() == null) {
            return ResponseEntity.badRequest().body("Stars must not be null");
        }

        ActivityReview review = new ActivityReview(dto.getUserId(), dto.getActivityId(), dto.getStars(), dto.getComment());
        activityReviewRepository.save(review);
        return ResponseEntity.ok("Review added successfully");
    }

    @DeleteMapping
    public ResponseEntity<Void> removeActivityReview(@RequestBody ActivityReviewDTO dto) {
        activityReviewRepository.deleteByUserIdAndActivityId(dto.getUserId(), dto.getActivityId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public List<ActivityReview> getReviewsByUserId(@PathVariable Integer userId) {
        return activityReviewRepository.findByUserId(userId);
    }

    @GetMapping("/activity/{activityId}")
    public List<ActivityReview> getReviewsByActivityId(@PathVariable Integer activityId) {
        return activityReviewRepository.findByActivityId(activityId);
    }

    @GetMapping
    public ResponseEntity<List<ActivityReview>> getAllActivityReviews() {
        return ResponseEntity.ok(activityReviewRepository.findAll());
    }

    @PutMapping
    public ResponseEntity<String> updateActivityReview(@RequestBody ActivityReviewDTO dto) {
        if (dto.getStars() == null) {
            return ResponseEntity.badRequest().body("Stars must not be null");
        }
        List<ActivityReview> reviews = activityReviewRepository.findByUserId(dto.getUserId())
                .stream()
                .filter(r -> r.getActivityId().equals(dto.getActivityId()))
                .toList();

        if (reviews.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ActivityReview review = reviews.get(0);
        review.setStars(dto.getStars());
        review.setComment(dto.getComment());
        review.setReviewedAt(java.time.LocalDateTime.now()); // update date
        activityReviewRepository.save(review);

        return ResponseEntity.ok("Review updated successfully");
    }
}