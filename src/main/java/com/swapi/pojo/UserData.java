package com.swapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class UserData {
    private Integer id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    private String last_name;
    private String avatar;

    public UserData(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
