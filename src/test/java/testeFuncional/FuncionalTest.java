package testeFuncional;

import br.com.databaseDTO.LoginDTO;
import br.com.databaseDTO.UserDTO;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import prova.BaseTest;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.CoreMatchers.is;

public class FuncionalTest extends BaseTest {

    @Test
    public void validaCreateNameEJob201(){

    LoginDTO bodyLogin = new LoginDTO();
        bodyLogin.setName("teste name");
        bodyLogin.setJob("teste job");

    given().
    contentType(ContentType.JSON).
    body(bodyLogin).log().all().
    when().
    post(URL_BASE_URI+"users").
    then().
    log().all().statusCode(201).body(CoreMatchers.containsString("createdAt"));
}

    @Test
    public void validaCreateSemJob201(){

        LoginDTO bodyLogin = new LoginDTO();
        bodyLogin.setName("testeName1");

        given().
                contentType(ContentType.JSON).
                body(bodyLogin).log().all().
                when().
                post(URL_BASE_URI+"users").
                then().
                log().all().statusCode(201).body(CoreMatchers.containsString("createdAt"));
    }


    @Test
    public void validaCreateSemName201(){

        LoginDTO bodyLogin = new LoginDTO();
        bodyLogin.setJob("testeJob1");

        given().
                contentType(ContentType.JSON).
                body(bodyLogin).log().all().
                when().
                post(URL_BASE_URI+"users").
                then().
                log().all().statusCode(201).body(CoreMatchers.containsString("createdAt"));
    }

    @Test
    public void validaCreateSemNameEJob201(){

        given().
                contentType(ContentType.JSON).log().all().
                when().
                post(URL_BASE_URI+"users").
                then().
                log().all().statusCode(201).body(CoreMatchers.containsString("createdAt"));

    }

    public void validaCreateNameEJob201(int idCriado){

        given().
                contentType(ContentType.JSON).
                log().all().
                when().
                post(URL_BASE_URI+"users/"+idCriado).
                then().
                log().all().statusCode(201).body(CoreMatchers.containsString("createdAt"));
    }

    @Test
    public void validaPostRegister200(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("eve.holt@reqres.in");
        bodyUser.setPassword("pistol");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"register").
                then().
                log().all().statusCode(200).body("id",is(4));
    }

    @Test
    public void validaPostRegister400(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("teste@gmail.com");
        bodyUser.setPassword("pistol");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"register").
                then().
                log().all().statusCode(400).body("error",is("Note: Only defined users succeed registration"));
    }

    @Test
    public void validaPostRegisterCampoObrigPassword400(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("teste@gmail.com");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"register").
                then().
                log().all().statusCode(400).body("error",is("Missing password"));
    }

    @Test
    public void validaPostRegisterCampoObrigPasswordEEmail400(){
        UserDTO bodyUser= new UserDTO();
        given().
                contentType(ContentType.JSON).
                log().all().
                when().
                post(URL_BASE_URI+"register").
                then().
                log().all().statusCode(400).body("error",is("Missing email or username"));
    }

    @Test
    public void validaPostRegisterCampoObrigEmail400(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setPassword("pistol");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"register").
                then().
                log().all().statusCode(400).body("error",is("Missing email or username"));
    }

    @Test
    public void validarPostLogin200(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("eve.holt@reqres.in");
        bodyUser.setPassword("cityslicka");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"login").
                then().
                log().all().statusCode(200).body("token",is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void validarPostLogin400(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("eve.holt@reqres.i");
        bodyUser.setPassword("cityslicka");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"login").
                then().
                log().all().statusCode(400).body("error",is("user not found"));
    }

    @Test
    public void validarPostLoginSemPassword400(){
        UserDTO bodyUser= new UserDTO();
        bodyUser.setEmail("eve.holt@reqres.in");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI+"login").
                then().
                log().all().statusCode(400).body("error",is("Missing password"));
    }

    @Test
    public void validarPostLoginSemEmail400() {
        UserDTO bodyUser = new UserDTO();
        bodyUser.setPassword("cityslicka");

        given().
                contentType(ContentType.JSON).
                body(bodyUser).log().all().
                when().
                post(URL_BASE_URI + "login").
                then().
                log().all().statusCode(400).body("error", is("Missing email or username"));
    }

    @Test
    public void validarPostLoginSemEmailePassword400(){

        given().
                contentType(ContentType.JSON).
                log().all().
                when().
                post(URL_BASE_URI+"login").
                then().
                log().all().statusCode(400).body("error",is("Missing email or username"));
    }
}
