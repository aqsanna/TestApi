package com.swapi.service;

import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import com.swapi.pojo.UserData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.List;

import static com.swapi.constant.Urls.*;
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
        requestSpecification.basePath(USER_LIST_URL);
        return  get(requestSpecification);
    }


    public static  Response singleUser(Integer id){
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.basePath(String.format(USER_URL, id));
        return get(requestSpecification);
    }


    public static  Response resourceList(){
        RequestSpecification requestSpecification =baseConfigRequest();
        requestSpecification.basePath(String.format(RESURCES_LIST_URL));
        return  get(requestSpecification);
    }

    public static Response singleResource(Integer pageNum){
        RequestSpecification requestSpecification =baseConfigRequest();
        requestSpecification.basePath(String.format(SINGLE_RESURCES_URL, pageNum));
        return get(requestSpecification);
    }

    public static Response createUser(String name, String job){
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.queryParam("name", name);
        requestSpecification.queryParam("job", job);
        return  post(requestSpecification, CREATE_USER_URL);
    }

    public static Response updateUsers(String requestBody, Integer pageNum) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.body(requestBody);
        return put(requestSpecification, pageNum);
    }

    public static Response updateUserByPatch(String requestBody, Integer pageNum) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.body(requestBody);
        return patch(requestSpecification, pageNum);
    }

    public static Response deleteUser(Integer userId){
        RequestSpecification requestSpecification = baseConfigRequest();
        return delete(requestSpecification, userId);
    }
}
