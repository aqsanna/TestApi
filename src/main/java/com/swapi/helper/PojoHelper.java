package com.swapi.helper;

import io.restassured.response.Response;

public class PojoHelper <T>{

    public T customExtract(Response response, Class<T> _class){
        return  response
                .then()
                .extract().as(_class);
    }
}