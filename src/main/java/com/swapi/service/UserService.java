package com.swapi.service;

import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import com.swapi.pojo.UserData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static com.swapi.constant.Urls.USER_URL;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class UserService extends BaseService {
    public List<UserData> userGet(String path){
        return  given()
                .when()
                .get(path )
                .then().log().all()
                .extract()
                .body()
                .jsonPath().getList("userData", UserData.class);
    }

    public static Response getUsers(Integer pageNumber){
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.queryParam("page",pageNumber);
        requestSpecification.basePath(USER_URL);
        return  get(requestSpecification);
    }
}
