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
@Table(name = "roadTrips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="route")
    private String route;

    @Column(name="days")
    private String days;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
////    @JsonIgnoreProperties("users")
//    private User user;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    // TODO: use @Builder for custom constructors
    //Constructors
    public RoadTrip(Integer id) {
        this.id = id;
    }

    public RoadTrip(String name, Integer userId) {
        this.name = name;
        this.userId = userId;
    }

    public RoadTrip(String name, String description, Integer userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    public RoadTrip(String name, String description, Integer userId, String route, String days) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.route = route;
        this.days = days;
    }
}
