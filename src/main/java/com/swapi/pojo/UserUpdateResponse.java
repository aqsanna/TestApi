package com.swapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateResponse {
    private User user;
    private String updatedAt;

    public UserUpdateResponse(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public UserUpdateResponse() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
