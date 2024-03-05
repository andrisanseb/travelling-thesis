package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.math.BigDecimal;
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


    @Column(name = "img_path")
    private String img_path;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @JsonIgnoreProperties("countries")
    private Country country;

    @Column
    private BigDecimal longitude;

    @Column
    private BigDecimal latitude;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("destination")
//    @JsonIgnore
    private List<Activity> activities;


    //Constructors
    public Destination (String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Destination (String name, String description, String img_path) {
        this.name = name;
        this.description = description;
        this.img_path = img_path;
    }

    public Destination (String name, String description, Country country, String img_path) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.img_path = img_path;
    }

    public Destination (String name, String description, Country country, String img_path, BigDecimal longitude, BigDecimal latitude) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.img_path = img_path;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Destination (String name, String description, List<Activity> activities) {
        this.name = name;
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

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
