package com.swapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateResponse {
    @JsonProperty("user")
    private User user;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;

    public UserCreateResponse(User user,  String id, String createdAt) {
        this.user = user;
        this.id = id;
        this.createdAt = createdAt;
    }

    public UserCreateResponse() {
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("id")
    public UserCreateResponse setId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("createdAt")
    public UserCreateResponse setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

}
