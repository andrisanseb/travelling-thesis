package com.thesis.model.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoadTripDTO {
    private int id;
    private String name;
    private String description;
    private Integer userId;
    private String route;
    private String days;

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
}
