package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "itineraries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_days")
    private int total_days;

    @Column(name = "total_cost")
    private int total_cost;

    @Column(name = "is_public")
    private boolean is_public;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    @JsonIgnoreProperties("itineraries")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("users")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "itinerary_activity",
            joinColumns = @JoinColumn(name = "itinerary_id"), inverseJoinColumns = @JoinColumn(name = "activity_id")
            )
    private List<Activity> activities;


    //Constructors
    public Itinerary ( String name, int total_days, Destination destination) {
        this.name = name;
        this.total_days = total_days;
        this.destination= destination;
    }

    public Itinerary ( String name, int total_days, boolean is_public) {
        this.name = name;
        this.total_days = total_days;
        this.is_public = is_public;
    }

    public Itinerary ( String name, int total_days, boolean is_public, Destination destination) {
        this.name = name;
        this.total_days = total_days;
        this.is_public = is_public;
        this.destination = destination;
    }

    public Itinerary ( String name, int total_days, Destination destination, List<Activity> activities) {
        this.name = name;
        this.total_days = total_days;
        this.destination= destination;
        this.activities = activities;
    }


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_days() {
        return total_days;
    }

    public void setTotal_days(int total_days) {
        this.total_days = total_days;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public boolean isIs_public() {
        return is_public;
    }

    public void setIs_public(boolean is_public) {
        this.is_public = is_public;
    }


    //Extra Methods
    public int calculateTotalCost() {
        int total_cost = 0;
        for (Activity activity: getActivities()) {
            total_cost += activity.getCost();
        }
        return total_cost;
    }

}
