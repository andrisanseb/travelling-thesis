package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "img_path")
    private String img_path;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("country")
    @JsonIgnore
    private List<Destination> destinations;


//    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("country")
//    @JsonIgnore
//    private List<Airport> airports;



    //Constructors
    public Country (String name) {
        this.name = name;
    }

    public Country (String name, String img_path) {
        this.name = name;
        this.img_path = img_path;
    }

//    public Country (String name, List<Airport> airports) {
//        this.name = name;
//        this.airports = airports;
//    }


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

//    public List<Airport> getAirports() { return airports; }
//
//    public void setAirports(List<Airport> airports) { this.airports = airports; }
//
    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
