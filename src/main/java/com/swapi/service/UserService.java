package com.swapi.service;

import com.swapi.pojo.UserData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.swapi.constant.Urls.*;
import static io.restassured.RestAssured.given;

public class UserService extends BaseService {
    public List<UserData> userGet(String path) {
        return given()
                .when()
                .get(path)
                .then().log().all()
                .extract()
                .body()
                .jsonPath().getList("userData", UserData.class);
    }

    public static Response getUsers(Integer pageNumber) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.basePath(String.format(USER_LIST_URL, pageNumber));
        return get(requestSpecification);
    }


    public static Response getUser(Integer id) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.basePath(String.format(USER_URL, id));
        return get(requestSpecification);
    }


    public static Response resourceList() {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.basePath(String.format(RESURCES_LIST_URL));
        return get(requestSpecification);
    }

    public static Response singleResource(Integer pageNum) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.basePath(String.format(SINGLE_RESURCES_URL, pageNum));
        return get(requestSpecification);
    }

    public static Response createUser(String name, String job) {
        RequestSpecification requestSpecification = baseConfigRequest();
        Map<String, String> createUser =  new HashMap<>();
        createUser.put("name", name);
        createUser.put("job", job);
        requestSpecification.body(createUser);
        return post(requestSpecification, CREATE_USER_URL);
    }

    public static Response updateUsers(String name, String job, Integer pageNum) {
        RequestSpecification requestSpecification = baseConfigRequest();
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("name", name);
        jsonBody.put("job", job);
        requestSpecification.body(jsonBody);
        return put(requestSpecification, pageNum);
    }

    public static Response updateUserPartial(String name, String job, Integer userId) {
        RequestSpecification requestSpecification = baseConfigRequest();
        Map<String, String> jsonBody =  new HashMap<>();
        jsonBody.put("name", name);
        jsonBody.put("job", job);
        requestSpecification.body(jsonBody);
        return patch(requestSpecification, userId);
    }

    public static Response deleteUser(Integer userId) {
        RequestSpecification requestSpecification = baseConfigRequest();
        return delete(requestSpecification, userId);
    }

    public static Response successRegister(String email, String password) {
        RequestSpecification requestSpecification = baseConfigRequest();
        Map<String, String> jsonBody =  new HashMap<>();
        jsonBody.put("email", email);
        jsonBody.put("password", password);
        requestSpecification.body(jsonBody);
        return post(requestSpecification, REGISTER_URL);
    }

    public static Response unSuccessRegister(String email) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.queryParam("email", email);
        return post(requestSpecification, REGISTER_URL);
    }

    public static Response successLogin(String email, String password) {
        RequestSpecification requestSpecification = baseConfigRequest();
        Map<String, String> jsonBody =  new HashMap<>();
        jsonBody.put("email", email);
        jsonBody.put("password", password);
        requestSpecification.body(jsonBody);
        return post(requestSpecification, LOGIN_URL);
    }

    public static Response unSuccessLogin(String email) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.queryParam("email", email);
        return post(requestSpecification, LOGIN_URL);
    }

    public static Response delayed(Integer id) {
        RequestSpecification requestSpecification = baseConfigRequest();
        requestSpecification.basePath(String.format(DELAY_URL, id));
        return get(requestSpecification);
    }
}
