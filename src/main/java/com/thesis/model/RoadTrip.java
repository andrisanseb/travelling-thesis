package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "roadTrips")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "destination_ids_ordered")   //array in postgresql
    private List<Integer> destination_ids_ordered;

    @Column(name = "activity_ids_list")
    private List<Integer> activity_ids_list;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("users")
    private User user;


    //Constructors
    public RoadTrip(Integer id) {
        this.id = id;
    }

    public RoadTrip(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public RoadTrip(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public RoadTrip(String name, String description, List<Integer> destination_ids_ordered, List<Integer> activity_ids_list, User user) {
        this.name = name;
        this.description = description;
        this.destination_ids_ordered = destination_ids_ordered;
        this.activity_ids_list = activity_ids_list;
        this.user = user;
    }

    //Getter and Setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getDestination_ids_ordered() {
        return destination_ids_ordered;
    }

    public void setDestination_ids_ordered(List<Integer> destination_ids_ordered) {
        this.destination_ids_ordered = destination_ids_ordered;
    }

    public List<Integer> getActivity_ids_list() {
        return activity_ids_list;
    }

    public void setActivity_ids_list(List<Integer> activity_ids_list) {
        this.activity_ids_list = activity_ids_list;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
