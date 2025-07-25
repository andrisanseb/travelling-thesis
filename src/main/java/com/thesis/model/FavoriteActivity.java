package com.thesis.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorite_activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "favorited_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime favoritedAt;

    // Constructors
    public FavoriteActivity(Integer userId, Integer activityId) {
        this.userId = userId;
        this.activityId = activityId;
    }
}
