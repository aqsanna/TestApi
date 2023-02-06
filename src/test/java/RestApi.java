
import com.swapi.service.MyBaseService;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.Test;

import static com.swapi.constant.Urls.PEOPLE_URL;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestApi {


    @Test
    public void getUrl() {
        String basePath = String.format(PEOPLE_URL,1);

        MyBaseService.get(basePath)
                //.prettyPrint()
                .then()
                .statusCode(200)
                .body("name", equalTo("Luke Skywalker"))
                .log().ifValidationFails(LogDetail.BODY).statusCode(200);
    }


}
