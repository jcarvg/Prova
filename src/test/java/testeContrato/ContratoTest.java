package testeContrato;


import br.com.databaseDTO.LoginDTO;
import br.com.databaseDTO.UserDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import prova.BaseTest;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.RestAssured.given;

public class ContratoTest extends BaseTest {


    @Test
    public void validarContratoPostCreate(){
        LoginDTO bodyLogin = new LoginDTO();
        bodyLogin.setName("morpheus");
        bodyLogin.setJob("leader");

        given().
                contentType(ContentType.JSON).
                body(bodyLogin).log().all().
        when().
                post(URL_BASE_URI+"users").
        then().
                log().all().body(matchesJsonSchema(new File("src\\test/resources\\schemas\\post_create_201_response.json")));
    }

    @Test
    public void validarContratoPostRegister(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("eve.holt@reqres.in");
        bodyUser.setPassword("pistol");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"register").
                then().
                log().all().body(matchesJsonSchema(new File("src\\test/resources\\schemas\\post_register_succesful.json")));
    }

    @Test
    public void validarContratoPostLogin(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("eve.holt@reqres.in");
        bodyUser.setPassword("cityslicka");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"login").
                then().
                log().all().body(matchesJsonSchema(new File("src\\test/resources\\schemas\\post_login_successful.json")));
    }

}
