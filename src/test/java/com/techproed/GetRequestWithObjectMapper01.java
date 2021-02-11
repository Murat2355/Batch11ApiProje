package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import Utilities.JSonUtil;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetRequestWithObjectMapper01 extends TestBaseJsonPlaceHolder {
    /*
	 	When
	 		I send GET Request to the URL https://jsonplaceholder.typicode.com/todos/198

	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }

     */

    @Test
    public void get01(){

        //1.adim ---url olustur
        spec01.pathParams("todosPath","todos",
                "id",198);

        //2.adim ---expected(beklenen) datayi olustur
        String expectedJson =  "{\n" +
                "\"userId\": 10,\n" +
                "\"id\": 198,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n" +
                " }";

        Map<String,Object> expectedMap = JSonUtil.convertJsonToJava(expectedJson, Map.class);
        System.out.println(expectedMap);

        //3.adim --request gonder
        Response response = given().
                                spec(spec01).
                                     when().
                                         get("/{todosPath}/{id}");

        response.prettyPrint();

        //4.adim ---actual data yi almak icin:  RsponseBody i Map a cevirecegiz...
        Map<String,Object> actualDataMap = JSonUtil.convertJsonToJava(response.asString(),Map.class);
        System.out.println(actualDataMap);


        //5.adim ---Assertion
        Assert.assertEquals(expectedMap.get("userId"),actualDataMap.get("userId"));
        Assert.assertEquals(expectedMap.get("completed"),actualDataMap.get("completed"));
        Assert.assertEquals(expectedMap.get("title"),actualDataMap.get("title"));
        Assert.assertEquals(expectedMap.get("id"),actualDataMap.get("id"));


    }



}
