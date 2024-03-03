package prova;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static  io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;


public abstract class BaseTest extends Util {

    Properties propriedades;


    @BeforeTest
    public void carregaURLs(){
        propriedades= new Properties();
        try {
            FileInputStream  arquivoAmbiente = new FileInputStream("ambiente.properties");
            propriedades.load(arquivoAmbiente);
            carregaURLsDoAmbiente();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void preCondicaodeTeste(Method method, ITestContext ctx) throws InterruptedException{
        carregaDadosPadrao();
    }

    public void carregaDadosPadrao(){
        baseURI = URL_BASE_URI;
    }

    public void carregaURLsDoAmbiente(){
        URL_BASE_URI = propriedades.getProperty("URL_BASE_URI");
    }

}

