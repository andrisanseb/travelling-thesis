package com.thesis.model.DTO;

public class RoadTripDTO {
    private int id;
    private String name;
    private String description;
    private Integer userId;
    private String route;
    private String days;


    // Constructors
    public RoadTripDTO() {}

    public RoadTripDTO(String name, String description, Integer userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    public RoadTripDTO(String name, String description, String route, String days, Integer userId) {
        this.name = name;
        this.description = description;
        this.route = route;
        this.days = days;
        this.userId = userId;
    }

    // Getters and Setters

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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
