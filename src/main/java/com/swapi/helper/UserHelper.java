package com.swapi.helper;

import com.swapi.pojo.UserData;
import com.swapi.service.UserService;

import java.util.List;

public class UserHelper {
    public static List<UserData> getUsers(Integer pageNumber) {
        return UserService.getUsers(pageNumber)
                .then()
                .extract()
                .body()
                .jsonPath().getList("userData", UserData.class);
    }
}
