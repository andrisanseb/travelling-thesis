package com.thesis.repository;

import com.thesis.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Review findById(int id);
    List<Review> findByReviewable_Id(int reviewable_id);
}
