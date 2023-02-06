package com.swapi.service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.swapi.utils.Configurations.BASE_URL;
import static io.restassured.RestAssured.given;

public class MyBaseService {

    public static Response get(String basePath ){

        return given()
                .baseUri(BASE_URL)
                .basePath(basePath)
                .contentType(ContentType.JSON)
                .when().get();
    }
}
