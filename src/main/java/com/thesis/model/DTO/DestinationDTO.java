package com.thesis.model.DTO;

public class DestinationDTO {

    private int id;
    private String name;
    private Integer nearest_airport_id;
    private String description;


    public DestinationDTO() {}


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


    public Integer getNearest_airport_id() {
        return nearest_airport_id;
    }

    public void setNearest_airport_id(Integer nearest_airport_id) {
        this.nearest_airport_id = nearest_airport_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
