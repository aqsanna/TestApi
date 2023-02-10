import com.swapi.helper.PojoHelper;
import com.swapi.helper.UserHelper;
import com.swapi.pojo.UserData;
import com.swapi.pojo.UserUpdateResponse;
import com.swapi.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static com.swapi.constant.Urls.USER_URL;
import static com.swapi.utils.UserInfo.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Every.everyItem;

public class UserDataTest {
    String basePath = String.format(USER_URL, 2);

    @Test
    public void checkAvatarAndId() {

        List<UserData> userData = UserHelper.getUsers(2);
        userData.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assert.assertTrue(userData.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));


    }

    @Test
    public void getUsers() {
        UserService.getUsers(2)
                .then()
                .body("data.avatar", everyItem(isA(String.class)),
                        "data.email", everyItem(endsWith("@reqres.in")));

    }

    @Test
    public void getSingleUser() {

        UserService.singleUser(USER_ID)
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", equalTo(USER_ID),
                        "data.email", endsWith(("@reqres.in")),
                        "data.first_name", equalTo(FIRST_NAME),
                        "data.last_name", equalTo(LAST_NAME));
    }

    @Test
    public void getSingleUserNotFound() {
        UserService.singleUser(USER_NOT_FOUND_ID)
                .then()
                .statusCode(404);
    }

    @Test
    public void getResourceList() {
        UserService.resourceList()
                .then()
                .log().all()
                .body("data.id", everyItem(isA(Integer.class)),
                        "data.name", everyItem(isA(String.class)),
                        "data.year", everyItem(isA(Integer.class)),
                        "data.color", everyItem(startsWith("#")),
                        "data.pantone_value", everyItem(isA(String.class)));

    }

    @Test
    public void getSingleResource() {
        UserService.singleResource(USER_ID)
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", isA(Integer.class),
                        "data.name", equalTo(SIGLE_RESOURCE_NAME),
                        "data.year", isA(Integer.class),
                        "data.color", startsWith("#"),
                        "data.pantone_value", isA(String.class));
    }

    @Test
    public void getSingleResourceNotFound() {
        UserService.singleResource(USER_NOT_FOUND_ID)
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void createUser() {
        UserService.createUser(FIRST_NAME, JOB)
                .then()
                .log().all()
                .statusCode(201)
                .body("id", isA(String.class));
    }

    @Test
    public void updateUser() {
        String requestBody = "{\n"
                + "  \"name\": \"morpheus\",\n"
                + "  \"job\": \"zion resident\"\n"
                + "}";
        UserService.updateUsers(requestBody, USER_ID)
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("morpheus"),
                        "job", equalTo("zion resident"));
    }


    @Test
    public void updateUserByPatch() {
        LocalDate date = LocalDate.now();

        String requestBody = "{\n"
                + "  \"name\": \"morpheus\",\n"
                + "  \"job\": \"zion resident\"\n"
                + "}";

        UserUpdateResponse userUpdateResponse = new PojoHelper<UserUpdateResponse>()
                .customExtract(UserService.updateUserByPatch(requestBody, USER_ID),
                        UserUpdateResponse.class);

        UserService.updateUserByPatch(requestBody, 2)
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("morpheus"),
                        "job", equalTo("zion resident"));

        Assert.assertEquals(userUpdateResponse.getUpdatedAt().substring(0, 10), date.toString());
    }

    @Test
    public void deleteUser() {
        UserService.deleteUser(USER_ID)
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test
    public void successRegister() {
        UserService.successRegister(EMAIL, PASSWORD)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", isA(Integer.class),
                        "token", isA(String.class));
    }

    @Test
    public void unSuccessRegister() {
        UserService.unSuccessRegister(EMAIL)
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void successLogin() {
        UserService.successLogin("eve.holt@reqres.in", "cityslicka")
                .then()
                .log().all()
                .statusCode(200)
                .body("token", isA(String.class));
    }

    @Test
    public void unSuccessLogin() {
        UserService.unSuccessLogin("eve.holt@reqres.in")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void getDelayed() {
        UserService.delayed(3)
                .then()
                .log().all()
                .statusCode(200)
                .body("data.id", everyItem(isA(Integer.class)),
                        "data.email", everyItem(endsWith("@reqres.in")),
                        "data.first_name", everyItem(isA(String.class)),
                        "data.last_name", everyItem(isA(String.class)),
                        "data.avatar", everyItem(isA(String.class)));
    }


}
