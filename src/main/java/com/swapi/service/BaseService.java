package com.swapi.service;

import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URL;

import static com.swapi.utils.Configurations.REQRES_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.GSON;

public class BaseService {
    protected static RequestSpecification baseConfigRequest() {

        return given()
                .baseUri(REQRES_URL)
                .config(RestAssured.config()
                .objectMapperConfig(new ObjectMapperConfig(GSON)))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON);

    }
    public static Response get(RequestSpecification requestSpecification) {

        requestSpecification.log().all();
        return requestSpecification.get();
    }
}
