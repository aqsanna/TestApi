package com.swapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateResponse {
    @JsonProperty("user")
    private User user;
    @JsonProperty("updatedAt")
    private String updatedAt;

    public UserUpdateResponse(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public UserUpdateResponse() {
    }


    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
