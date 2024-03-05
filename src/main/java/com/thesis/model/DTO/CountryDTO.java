package com.thesis.model.DTO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CountryDTO {

    private int id;
    private String name;

    private String img_path;


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
}
