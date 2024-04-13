package com.thesis.model.DTO;

public class ActivityDTO {

    private int id;
    private String name;
    private String description;
    private int cost;
    private int destination_id;
    private String category;


    public ActivityDTO() {}


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

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}
