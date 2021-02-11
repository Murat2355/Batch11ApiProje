package com.techproed;

import TestBase.TestBaseHerOkuApp;
import Utilities.JSonUtil;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetRequestWithObjectMapper02 extends TestBaseHerOkuApp {
    /*
		 	When
		 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2

		 	Then
		 		Status code is 200
		 		And response body is like {
										    "firstname": "Mark",
										    "lastname": "Ericsson",
										    "totalprice": 726,
										    "depositpaid": true,
										    "bookingdates": {
										        "checkin": "2015-08-07",
										        "checkout": "2020-10-25"
										     }
										  }

		 */

    @Test
    public void get01(){
        //url olustur
        spec02.pathParam("id",2);

        //expected data olustur
        String expectedJson = "{\n" +
                "\"firstname\": \"Jim\",\n" +
                "\"lastname\": \"Jones\",\n" +
                "\"totalprice\": 726,\n" +
                "\"depositpaid\": false,\n" +
                "\"bookingdates\": {\n" +
                "    \"checkin\": \"2017-12-30\",\n" +
                "    \"checkout\": \"2020-02-20\"\n" +
                "}\n" +
                "}";
        Map<String,Object> expectedDataMap = JSonUtil.convertJsonToJava(expectedJson, Map.class);
        System.out.println(expectedDataMap);

        //request gonder
        Response response = given().
                               spec(spec02).
                                   when().
                                          get("/{id}");
        response.prettyPrint();

        //actual data icin response body i de serializate etmemeiz lazim

        Map<String,Object> actualDataMap = JSonUtil.convertJsonToJava(response.asString(),Map.class);
        System.out.println(actualDataMap);

        //Assertion
        response.
                 then().
                     assertThat().
                           statusCode(200);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualDataMap.get("firstname"),expectedDataMap.get("firstname"));
        softAssert.assertEquals(actualDataMap.get("lastname"),expectedDataMap.get("lastname"));
        softAssert.assertEquals(actualDataMap.get("totalprice"),expectedDataMap.get("totalprice"));
        softAssert.assertEquals(actualDataMap.get("depositpaid"),expectedDataMap.get("depositpaid"));
        softAssert.assertEquals(((Map)actualDataMap.get("bookingdates")).get("checkin"),((Map)expectedDataMap.get("bookingdates")).get("checkin"));
        softAssert.assertEquals(((Map)actualDataMap.get("bookingdates")).get("checkout"),((Map)expectedDataMap.get("bookingdates")).get("checkout"));
        softAssert.assertAll();
    }
}
