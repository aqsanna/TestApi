package com.swapi.pojo;

public class UserCreateResponse {
    private String name;
    private String job;
    private String id;
    private String createdAt;

    public UserCreateResponse(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
