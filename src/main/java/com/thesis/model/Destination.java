package com.thesis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

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

    // Constructors
    public Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Destination(String name, String description, String img_path) {
        this.name = name;
        this.description = description;
        this.img_path = img_path;
    }

    public Destination(String name, String description, Country country, String img_path) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.img_path = img_path;
    }

    public Destination(String name, String description, Country country, String img_path, BigDecimal longitude, BigDecimal latitude) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.img_path = img_path;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Destination(int id) {
        this.id = id;
    }
}
