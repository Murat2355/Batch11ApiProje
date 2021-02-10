package com.techproed;

import TestBase.TestBaseDummy;
import TestData.DummyTestData;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import java.util.Map;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class DeleteRequest01 extends TestBaseDummy {
    /*
	 	When
	 		I send DELETE Request to the Url http://dummy.restapiexample.com/api/v1/delete/2
	 	Then
		 	Status code is 200
		 	And Response body is {
								    "status": "success",
								    "data": "2",
								    "message": "Successfully! Record has been deleted"
								 }
	*/
    @Test
    public void delete01(){
        spec03.pathParams("deletePath","delete",
                "id",2);
        // ReqBody olusturucam
        DummyTestData expectedObj = new DummyTestData();
        Map<String,Object> expectedDataMap = expectedObj.setUpExpectedDeleteDataByUsingMap();

        // Request i olustur
        Response response = given().
                               spec(spec03).
                                   when().
                                      delete("/{deletePath}/{id}");
        response.prettyPrint();
        // Assertion
        // Body ile expectedData
        response.then().
                    assertThat().
                      statusCode(200).
                            body("status", equalTo(expectedDataMap.get("status")),
                                "data",equalTo(expectedDataMap.get("data")),
                                    "message",equalTo(expectedDataMap.get("message")));

        //2.Way: JsonPath + expectedDataMap + Hard Assert
        //3.Way: GSON + expectedDataMap + Soft Assert

    }

}