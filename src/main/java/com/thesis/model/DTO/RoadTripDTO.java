package com.thesis.model.DTO;

import java.util.List;

public class RoadTripDTO {
    private int id;
    private String name;
    private String description;
//    private List<Integer> destination_ids_ordered;
//    private List<Integer> activity_ids_list;
    private String route;
    private String days;

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
}
