package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activities")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private int duration;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    @JsonIgnoreProperties("destinations")
    private Destination destination;

    @Column(name = "category")
    private String category;


//    //Constructors
//    public Activity (String name, String description, int cost) {
//        this.name = name;
//        this.description = description;
//        this.cost = cost;
//    }
//
//    public Activity (String name, String description, int cost, int duration) {
//        this.name = name;
//        this.description = description;
//        this.cost = cost;
//        this.duration = duration;
//    }
//
//    public Activity (String name, String description, int cost, Destination destination) {
//        this.name = name;
//        this.description = description;
//        this.cost = cost;
//        this.destination = destination;
//    }
//
//    public Activity (String name, String description, int cost, Destination destination, String category) {
//        this.name = name;
//        this.description = description;
//        this.cost = cost;
//        this.destination = destination;
//        this.category = category;
//    }
//
//    public Activity (int id) {
//        this.id = id;
//    }


    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}
