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

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("country")
    @JsonIgnore
    private List<Airport> airports;

//    @OneToMany(mappedBy = "country")
//    @JsonIgnoreProperties("country")
//    @JsonIgnore
//    private List<User> users;



    //Constructors
    public Country (String name) {
        this.name = name;
    }

    public Country (String name, List<Airport> airports) {
        this.name = name;
        this.airports = airports;
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

    public List<Airport> getAirports() { return airports; }

    public void setAirports(List<Airport> airports) { this.airports = airports; }

}
