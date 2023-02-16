package com.swapi.helper;

import io.restassured.response.Response;

import java.lang.reflect.Type;

public class PojoHelper<T> {

    private PojoHelper() {
    }

    public static <T> T customExtract(Response response, Class<T> _class) {
        return response
                .then()
                .extract().as(_class);
    }

    public static <T> T customExtract(Response response, Type type) { // Type interface
        return response
                .then()
                .extract().as(type);
    }
}