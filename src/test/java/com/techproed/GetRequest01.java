package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
     /*
       Given: Baslangıc icin gereklilikleri ifade eder.
       When: Kullanicinin aksiyonunu ifade eder.
       Then: Ciktilari ifade eder-- Assert ler genelde burada yapilir
       And: Herhangi iki coklu adim arasinda kullanilabilir.

        Positive Scenario
      When I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
      Then
      HTTP Status code should be 200
      And  Content type should be Json
      And  Status Line should be HTTP/1.1 200 OK
    */
    @Test
    public void get01(){
        //1. is url olusturmak
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //2. Beklenen datayi olusturmak
        //3. Request gonderme---send butonuna basmak
        //Response Class
        Response response = given().
                accept("application/json").//accept type in json formatinada olmasini sagliyor
                when().
                get(url);
        response.prettyPrint();//gelen responsu consolde gormus oldum

        //4. Assert islemi
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

        //Konsolde status code ,status line, gorelim.
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getTime());



    }
}
