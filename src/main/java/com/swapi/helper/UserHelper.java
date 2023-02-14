package com.swapi.helper;

import com.swapi.pojo.*;
import com.swapi.service.UserService;

import java.util.List;

import static com.swapi.helper.PojoHelper.customExtract;
import static com.swapi.utils.UserInfo.USER_ID;

public class UserHelper {

    private UserHelper() {
    }

    ;

    public static List<UserData> getUsers(Integer pageNumber) {
//        return UserService.getUsers(pageNumber)
//                .then()
//                .extract()
//                .body()
//                .jsonPath().getList("userData", UserData.class);
        return customExtract(UserService.getUsers(pageNumber), "userData", UserData.class);
    }


    public static UserUpdateResponse updateUserPartial(String name, String job, Integer pageNum) {
        return PojoHelper.customExtract(UserService.updateUserPartial(name, job, pageNum),
                UserUpdateResponse.class);
    }
    public static UserUpdateResponse updateUsers(String name, String job, Integer pageNum) {
        return PojoHelper.customExtract(UserService.updateUsers(name, job, pageNum),
                UserUpdateResponse.class);
    }

    public static UserCreateResponse createUser(String name, String job) {
        return PojoHelper.customExtract(UserService.createUser(name, job),
                UserCreateResponse.class);
    }
    public static UserResponse getUser(Integer id) {
        return PojoHelper.customExtract(UserService.getUser(id),
                UserResponse.class);
    }
    public static UserRegisterResponse successRegister(String email, String password) {
        return PojoHelper.customExtract(UserService.successRegister(email, password),
                UserRegisterResponse.class);
    }
}
