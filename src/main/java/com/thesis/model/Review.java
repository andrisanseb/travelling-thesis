package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "reviewable_type")
    private Integer reviewable_type;

    @Column(name = "reviewable_id")
    private Integer reviewable_id;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "comment")
    private String comment;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Constructors

    public Review(Integer user_id, Integer reviewable_type, Integer reviewable_id, Integer stars, String comment) {
        this.user_id = user_id;
        this.reviewable_type = reviewable_type;
        this.reviewable_id = reviewable_id;
        this.stars = stars;
        this.comment = comment;
    }

    public Review(Integer user_id, Integer reviewable_type, Integer reviewable_id, Integer stars) {
        this.user_id = user_id;
        this.reviewable_type = reviewable_type;
        this.reviewable_id = reviewable_id;
        this.stars = stars;
    }

    // Getters, Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getReviewable_type() {
        return reviewable_type;
    }

    public void setReviewable_type(Integer reviewable_type) {
        this.reviewable_type = reviewable_type;
    }

    public Integer getReviewable_id() {
        return reviewable_id;
    }

    public void setReviewable_id(Integer reviewable_id) {
        this.reviewable_id = reviewable_id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
