package com.swapi.pojo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "token"
})
public class UserRegisterResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("token")
    private String token;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserRegisterResponse{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
