package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest06 extends TestBaseJsonPlaceHolder {

    /* 1)When I send a GET request to REST API URL
						 https://jsonplaceholder.typicode.com/todos/123
					     Then HTTP Status Code should be 200
					     And "Server" in Headers should be "cloudflare"
					     And response content type is “application/JSON”
					     And "userId" should be 7,
					     And "title" should be "esse et quis iste est earum aut impedit"
						 And "completed" should be false
						  */
    @Test
    public void get01(){
        //uRL i olusturma
        spec01.pathParams("name","todos","id",123);


        //Data yi olusturmak--sonra

        //Request gonder
        //Burasi bizim test body imiz.
        //Bu kismi sabit  tutmaya calisiyoruz
        //Sadece yukaridaki kismi degistirerek testlerimizi yapiyoruz.
        Response response = given().
                              spec(spec01).
                                when().
                                  get("/{name}/{id}");

        response.prettyPrint();
        //Assertion yap
        response.
                then().
                  assertThat().
                    statusCode(200).
                      header("Server","cloudflare");

        response.
                then().
                  assertThat().
                    contentType(ContentType.JSON).
                      body("userId", equalTo(7),
                              "id",equalTo(123),
                                    "title",equalTo("esse et quis iste est earum aut impedit"),
                                        "completed",equalTo(false));

    }
}
