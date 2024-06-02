package com.thesis.model.DTO;

public class FavoriteActivityDTO {
    private Integer userId;
    private Integer activityId;

    // Constructors
    public FavoriteActivityDTO() {}

    public FavoriteActivityDTO(Integer userId, Integer activityId) {
        this.userId = userId;
        this.activityId = activityId;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }
}
