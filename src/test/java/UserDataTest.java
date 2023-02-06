import com.swapi.helper.UserHelper;
import com.swapi.pojo.UserData;
import com.swapi.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.swapi.constant.Urls.USER_URL;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.isA;
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
    public void getUsers(){
        UserService.getUsers(2)
                .then()
                .body("data.avatar", everyItem(isA(String.class)),
                        "data.email", everyItem(endsWith("@reqres.in")));

    }
}
