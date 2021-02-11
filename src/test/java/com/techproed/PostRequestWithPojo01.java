package com.techproed;

import Pojos.TodosPojo;
import TestBase.TestBaseJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

public class PostRequestWithPojo01 extends TestBaseJsonPlaceHolder {
     /*
    Plain Old Java Objects--
    Pojo Class ları olusturmak icin izlenmesi gereken adımlar
    1) Json dataya bakılarak her bir key icin bir private degisken olusturulması
    2) Private degiskenlere erisebbilmek icin getter ve setter ları olusturcam
    3) DEfault- Parametresiz Constructor olusturucam
    4) Parametreli constructor olusturucaz------ Nesne olusturmada kullanıcaz****
    5) toString metodunu olusturucaz---- actual veya expected datayı gorebilmek icin
     */

    	/*
	 	When
	 		I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
	 		with Post Request body  {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }
	 	Then
	 		Status code is 201
	 		And response body is like {
									    "userId": 21,
									    "id": 201,
									    "title": "Tidy your room",
									    "completed": false
									  }

	 */
    @Test
    public void postPojo01(){
        //Url Olustur
        spec01.pathParam("todoPath","todos");

        //Expected Data yi olusturalim.

        TodosPojo expectedPojoData = new TodosPojo(21,201,"Tidy your room",false);

        //Request gonderelim
        Response response = given().
                              contentType(ContentType.JSON).
                                 spec(spec01).
                                    body(expectedPojoData).
                                         when().
                                              post("/{todoPath}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(201).
                body("userId",equalTo(expectedPojoData.getUserId()),
                "id",equalTo(expectedPojoData.getId()),
                "title",equalTo(expectedPojoData.getTitle()),
                "completed",equalTo(expectedPojoData.isCompleted()));

        //2. yol -- jsonPath ve pojo ile

        //3.yol GSon ve pojo ile
        TodosPojo actualTodosData = response.as(TodosPojo.class);
        System.out.println(actualTodosData);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTodosData.getUserId(),expectedPojoData.getUserId());
        softAssert.assertEquals(actualTodosData.getId(),expectedPojoData.getId());
        softAssert.assertEquals(actualTodosData.getTitle(),expectedPojoData.getTitle());
        softAssert.assertEquals(actualTodosData.isCompleted(),expectedPojoData.isCompleted());

        softAssert.assertAll();
    }
}























