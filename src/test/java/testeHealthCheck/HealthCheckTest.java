package prova;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class HealthCheckTest extends BaseTest {

    @Test
    public void healthCheckTestApi(){
        given().
                contentType("application/json").
        when().
                get("https://reqres.in/api-docs/#/default").
        then().
                log().all().statusCode(200);

    }

}
