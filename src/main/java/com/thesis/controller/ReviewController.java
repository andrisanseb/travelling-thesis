package com.thesis.controller;



import com.thesis.model.DTO.DestinationDTO;
import com.thesis.model.DTO.ReviewDTO;
import com.thesis.model.Destination;
import com.thesis.model.Review;
import com.thesis.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    private record ReviewSingleDTO (String status, ReviewDTO data) {}
    private record ReviewListDTO (String status, List<ReviewDTO> data) {}

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;


    //POST ENDPOINTS
    @PostMapping
    public ResponseEntity<ReviewController.ReviewSingleDTO> createReview(@RequestBody Review review) {
        Review reviewToCreate = review;

        this.reviewRepository.save(reviewToCreate);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ReviewController.ReviewSingleDTO("success", modelMapper
                        .map(reviewToCreate, ReviewDTO.class)
                ));
    }

    //TODO: get all of dest/act, get all of user, get specific
}
