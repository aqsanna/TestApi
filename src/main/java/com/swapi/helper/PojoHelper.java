package com.swapi.helper;

import io.restassured.response.Response;

import java.util.List;

public class PojoHelper <T>{

    private PojoHelper(){
    }

    public static <T>  T customExtract(Response response, Class<T> _class){
        return  response
                .andReturn().as(_class);
    }
    public static <T> List<T> customExtract(Response response, String name, Class<T> _class){ // jnjel ogtagorcelov arajin customExtracty u stanal userneri list
        return  response
               .andReturn().jsonPath().getList(name,_class);
    }
}