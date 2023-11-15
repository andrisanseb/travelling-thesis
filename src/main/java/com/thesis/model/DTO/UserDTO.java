package com.thesis.model.DTO;

public class UserDTO {

    private int id;
    private String username;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private int nearest_airport_id;


    public UserDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getNearest_airport_id() {
        return nearest_airport_id;
    }

    public void setNearest_airport_id(Integer nearest_airport_id) {
        this.nearest_airport_id = nearest_airport_id;
    }

}
