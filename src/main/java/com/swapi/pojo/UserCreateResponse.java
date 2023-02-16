package com.swapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateResponse {

    private User user;
    private String id;
    private String createdAt;

    public UserCreateResponse(User user,  String id, String createdAt) {
        this.user = user;
        this.id = id;
        this.createdAt = createdAt;
    }

    public UserCreateResponse() {
    }

    public String getId() {
        return id;
    }


    public String getCreatedAt() {
        return createdAt;
    }


    public UserCreateResponse setId(String id) {
        this.id = id;
        return this;
    }

    public UserCreateResponse setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
