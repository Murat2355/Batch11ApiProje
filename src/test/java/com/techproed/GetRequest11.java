package com.techproed;

import TestBase.TestBaseJsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest11 extends TestBaseJsonPlaceHolder {

	/*
	When
	 I send GET Request to jsonplaceholder api/todos/2
	 Status code: 200
	 "completed": is false
	 "title
	 "userId"
	 header "via"
	 header "Server"
	De-Serialization: JSON datasını Java Objelerine (Map,List,List of Map, Set) cevirme islemidir.
    GSON dependency sini kullanarak De-SErialization ve Serialization yapılabilir.
    ,
         */
    @Test
    public void get01(){
        // Url i olustur.
        spec01.pathParams("todos","todos","id",2);

        // 2. Expected Datayı (test data) olustur.
        HashMap<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("Status Code",200);
        expectedDataMap.put("userId",1);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("completed",false);
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");

        //3. REquest olustur
        Response response = given().
                              spec(spec01).
                                 when().
                                     get("/{todos}/{id}");
        response.prettyPrint();

        // 1. yol body kullanarak assert edelim
        // body("completed",equealTo(expectedDataMap.get("completed"))


    }
}
