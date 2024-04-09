package com.thesis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name="created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    @JsonIgnore
    private List<RoadTrip> roadTrips;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("user")
//    @JsonIgnore
//    private List<FavoriteDestination> favoriteDestinations;


//    @OneToMany(mappedBy = "user")
//    @JsonIgnoreProperties("user")
//    @JsonIgnore
//    private List<UserFollows> user_follows;


    //Constructors

    public User (String first_name, String last_name, String username, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id) {
        this.id = id;
    }


    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public List<RoadTrip> getRoadTrips() {
        return roadTrips;
    }

    public void setRoadTrips(List<RoadTrip> roadTrips) {
        this.roadTrips = roadTrips;
    }

//    public List<FavoriteDestination> getFavoriteDestinations() {
//        return favoriteDestinations;
//    }
//
//    public void setFavoriteDestinations(List<FavoriteDestination> favoriteDestinations) {
//        this.favoriteDestinations = favoriteDestinations;
//    }
//    public List<User> getUser_follows() { return user_follows; }
//    public void setUser_follows(List<User> user_follows) { this.user_follows = user_follows; }


}
