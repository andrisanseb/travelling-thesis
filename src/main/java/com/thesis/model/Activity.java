package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private int cost;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    @JsonIgnoreProperties("activities")
    private Destination destination;

    @Column(name = "category")
    private String category;

    @Column(name = "created_by_user_id")
    private Integer createdByUserId;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    // Constructor with all fields except createdAt
    public Activity(String name, String description, int cost, Integer duration, Destination destination, String category, Integer createdByUserId) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.duration = duration;
        this.destination = destination;
        this.category = category;
        this.createdByUserId = createdByUserId;
    }

    // Constructor with only required fields
    public Activity(String name, String description, int cost, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.destination = destination;
    }

}
