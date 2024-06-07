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

    //Getter and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRoute() { return route; }

    public void setRoute(String route) { this.route = route; }

    public String getDays() { return days; }

    public void setDays(String days) { this.days = days; }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
