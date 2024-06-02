package com.thesis.repository;

import com.thesis.model.FavoriteActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FavoriteActivityRepository extends JpaRepository<FavoriteActivity, Integer> {
    List<FavoriteActivity> findByUserId(Integer userId);
    List<FavoriteActivity> findByActivityId(Integer activityId);

    @Modifying
    @Transactional
    @Query("DELETE FROM FavoriteActivity f WHERE f.userId = :userId AND f.activityId = :activityId")
    void deleteByUserIdAndActivityId(Integer userId, Integer activityId);

}
