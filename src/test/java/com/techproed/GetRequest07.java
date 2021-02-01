package com.techproed;

import TestBase.TestBaseHerOkuApp;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;



import static io.restassured.RestAssured.*;

public class GetRequest07 extends TestBaseHerOkuApp {

    /*
     * When I send a GET request to REST API URL
     * https://restful-booker.herokuapp.com/booking/5
     * Then HTTP Status Code should be 200
     * And response content type is “application/JSON”
     * And response body should be like;
     * {"firstname": "Mary",
     *   "lastname": "Ericsson",
     *   "totalprice": 558,
     *   "depositpaid": true,
     *   "bookingdates": { "checkin": "2019-10-20",
     *                     "checkout":"2020-08-25" }
     * }
     */

    @Test
    public void get01(){
        //url olusturma
        spec02.pathParam("bookingid",5);

        //Request olustur
        Response response = (Response) given().
                                 spec(spec02).
                                       when().
                                            get("/{bookingid}");
        response.prettyPrint();

        response.
                then().
                   assertThat().
                      assertThat().
                         statusCode(200).
                            contentType(ContentType.JSON);



        //1.yol(yeni yol)
        //jsonPath();
             //respons un icerisinde hareket edebilmemizi ve degerlere ulasabilmemizi sagliyor.
        JsonPath jsonPath = response.jsonPath();//once jsonPath() objesi olusturuyoruz.

        System.out.println("Firstname : "+jsonPath.getString("firstname"));//response icerisinde direk firstname i getirdi.
        Assert.assertEquals("Firstname istenilen gibi degil","Eric",jsonPath.getString("firstname"));

        System.out.println("Lastname : "+jsonPath.getString("lastname"));
        Assert.assertEquals("Lastname istenilen gibi degil","Wilson",jsonPath.getString("lastname"));

        System.out.println("Totalprice : "+jsonPath.getInt("totalprice"));
        Assert.assertEquals("Totalprice istenilen gibi degil",276,jsonPath.getInt("totalprice"));

        System.out.println("Depositpaid : "+jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals("Depositpaid istenilen gibi degil",false,jsonPath.getBoolean("depositpaid"));

        System.out.println("Check out tarihi : "+jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals("Bookingdates istenilen gibi degil","2020-08-17",jsonPath.getString("bookingdates.checkin"));

        System.out.println("Check out tarihi : "+jsonPath.getString("bookingdates.checkout"));
        Assert.assertEquals("Bookingdates istenilen gibi degil","2020-09-05",jsonPath.getString("bookingdates.checkout"));


        //2.yol matchers

        response.
                then().
                   assertThat().
                     body("firstname", equalTo("Eric"),
                       "lastname",equalTo("Wilson"),
                          "totalprice",equalTo(276),
                              "depositpaid",equalTo(false),
                                   "bookingdates.checkin",equalTo("2020-08-17"),
                                        "bookingdates.checkout",equalTo("2020-09-05"));


    }

}
