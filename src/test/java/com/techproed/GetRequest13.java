package com.techproed;

import TestBase.TestBaseHerOkuApp;
import TestData.HerOkuAppTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetRequest13 extends TestBaseHerOkuApp {
    /*
	 	When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
	 	Then
	 		Response body should be like that;
	 		{
			    "firstname": "Eric",
			    "lastname": "Smith",
			    "totalprice": 555,
			    "depositpaid": false,
			    "bookingdates": {
			        "checkin": "2016-09-09",
			        "checkout": "2017-09-21"
			     }
			}
	*/
    @Test
    public void get01(){
        //1- url olustur

        spec02.pathParam("bookingId","1");

        //ecpected data(beklenen data) yi olustur
        HerOkuAppTestData expectedObje = new HerOkuAppTestData();
        Map<String,Object> expectedDataMap = expectedObje.setUpData();
        System.out.println(expectedDataMap);


        //3- response gonder
        Response response = given().
                               spec(spec02).
                                       when().get("/{bookingId}");
        //response.prettyPrint();


        //
        // assertion de serialization
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);
        Assert.assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        Assert.assertEquals(((Map)expectedDataMap.get("bookingDates")).get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedDataMap.get("bookingDates")).get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));
    }
}
