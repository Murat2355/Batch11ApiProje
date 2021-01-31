package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetRequest03 {
    /*
	 Positive Scenario:
	 When Asagidaki Endpoint'e bir GET request yolladim
	 https://restful-booker.herokuapp.com/booking/7
     And Accept type “application/json” dir
      Then
     HTTP Status Code 200
     And Response format "application/json"
     And firstname "Eric"
     And lastname "Brown"
     And checkin date "2016-05-20"
     And checkout date "2020-12-18"
	*/
    @Test
    public void get01(){
        String url = "https://restful-booker.herokuapp.com/booking/7";

        Response response =  given().
                accept("application/json").
                when().
                get(url);

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        // 1. yol
        //burda body nin icindeki datalari assert yaptik.
        response.then().
                assertThat().
                body("firstname", equalTo("Jim")).
                body("lastname", equalTo("Jones")).
                body("totalprice", equalTo(932)).
                body("depositpaid", equalTo(false)).
                body("bookingdates.checkin", equalTo("2018-02-17")).
                body("bookingdates.checkout", equalTo("2020-09-24"));
                 //    body("additionalneeds",Matchers.equalTo("Breakfast"));

        //2.yol
        // Tekrarli body lerden kurtulak istiyorum.
        response.
                then().
                assertThat().
                body("firstname",equalTo("Jim"),
                        "lastname", equalTo("Jones"),
                        "totalprice", equalTo(932),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2018-02-17"),
                        "bookingdates.checkout", equalTo("2020-09-24")
                        );

    }
}
