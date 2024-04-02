package com.thesis.model.DTO;

public class ReviewDTO {
    private int id;
    private int user_id;
    private int reviewable_type;
    private int reviewable_id;
    private int stars;
    private String comment;

    public ReviewDTO() {}


    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getReviewable_type() {
        return reviewable_type;
    }

    public void setReviewable_type(int reviewable_type) {
        this.reviewable_type = reviewable_type;
    }

    public int getReviewable_id() {
        return reviewable_id;
    }

    public void setReviewable_id(int reviewable_id) {
        this.reviewable_id = reviewable_id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
