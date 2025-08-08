package com.thesis.repository;

import com.thesis.model.ActivityReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActivityReviewRepository extends JpaRepository<ActivityReview, Integer> {
    List<ActivityReview> findByUserId(Integer userId);
    List<ActivityReview> findByActivityId(Integer activityId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ActivityReview f WHERE f.userId = :userId AND f.activityId = :activityId")
    void deleteByUserIdAndActivityId(Integer userId, Integer activityId);

}
