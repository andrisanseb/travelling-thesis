package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "destinations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "nearest_airport_id")
    private Integer nearest_airport_id;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("destination")
    @JsonIgnore
    private List<Activity> activities;


    //Constructors
    public Destination (String name, Integer nearest_airport_id, String description) {
        this.name = name;
        this.nearest_airport_id = nearest_airport_id;
        this.description = description;
    }

    public Destination (String name, Integer nearest_airport_id, String description, List<Activity> activities) {
        this.name = name;
        this.nearest_airport_id = nearest_airport_id;
        this.description = description;
        this.activities = activities;
    }

    public Destination(int id) {
        this.id = id;
    }


    //Getters and Setters
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

    public Integer getNearest_airport_id() { return nearest_airport_id; }

    public void setNearest_airport_id(Integer nearest_airport_id) { this.nearest_airport_id = nearest_airport_id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
