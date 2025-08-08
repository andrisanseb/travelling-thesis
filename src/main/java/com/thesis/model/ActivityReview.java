package com.thesis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "activity_reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "comment")
    private String comment;

    @Column(name = "reviewed_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime reviewedAt;

    // Constructors
    public ActivityReview(Integer userId, Integer activityId, Integer stars) {
        this.userId = userId;
        this.activityId = activityId;
        this.stars = stars;
    }

    public ActivityReview(Integer userId, Integer activityId, Integer stars, String comment) {
        this.userId = userId;
        this.activityId = activityId;
        this.stars = stars;
        this.comment = comment;
    }

}
