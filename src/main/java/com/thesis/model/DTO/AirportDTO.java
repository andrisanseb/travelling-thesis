package com.thesis.model.DTO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AirportDTO {

    private int id;

    private String code;

    private String name;


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
