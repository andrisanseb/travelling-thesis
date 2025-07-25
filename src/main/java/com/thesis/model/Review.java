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
}
