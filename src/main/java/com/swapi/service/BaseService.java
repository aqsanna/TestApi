package com.swapi.service;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.config.ObjectMapperConfig;


import static com.swapi.constant.Urls.DELETE_USER_URL;
import static com.swapi.constant.Urls.UPDATE_USER_URL;
import static com.swapi.utils.Configurations.REQRES_URL;
import static io.restassured.RestAssured.given;
import static io.restassured.mapper.ObjectMapperType.GSON;
import io.restassured.mapper.ObjectMapperType;


public class BaseService {
    protected static RequestSpecification baseConfigRequest() {

        return given()
                .baseUri(REQRES_URL)
                .config(RestAssured.config()
                        .objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)))
                .contentType(ContentType.JSON)
                .log().all();

    }

    public static Response get(RequestSpecification requestSpecification) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.get();
    }

    public static Response post(RequestSpecification requestSpecification, String basePath) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.post(basePath);
    }

    public static Response put(RequestSpecification requestSpecification, Integer pageNum) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.put(String.format(UPDATE_USER_URL, pageNum));
    }

    public static Response patch(RequestSpecification requestSpecification, Integer pageNum) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.patch(String.format(UPDATE_USER_URL, pageNum));
    }

    public static Response delete(RequestSpecification requestSpecification, Integer userId) {
        requestSpecification.log().ifValidationFails();
        return requestSpecification.delete(String.format(DELETE_USER_URL, userId));
    }
}
