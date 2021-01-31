package com.techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequest05 {
     /*
    When I send a GET request to REST API URL
      https://restful-booker.herokuapp.com/booking/5
    Then HTTP Status Code 200 olsun
    And Response content type "application/JSON" olsun
    And "firstname" "Jim" olsun
    And "totalprice" 602 olsun
 And "checkin" "2015-06-12" olsun
*/
    @Test
    public void get01(){
        String url ="https://restful-booker.herokuapp.com/booking/5";

        Response response = given().
                when().
                get(url);

        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                body("firstname", Matchers.equalTo("Mark")).
                body("totalprice",Matchers.equalTo(821)).
                body("bookingdates.checkin",Matchers.equalTo("2015-05-10"));


    }
}
