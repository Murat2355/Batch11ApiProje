package com.techproed;

import TestBase.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


import org.junit.Assert;
import org.junit.Test;



import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest09 extends TestBaseDummy {
    /*
		 				Warm Up (10 Minutes)
		 1)Create a class and name it as GetRequest09
		 2)When
		 	 I send a GET Request to http://dummy.restapiexample.com/api/v1/employees
		 Then
			 status code is 200
			 And the name of the 5th employee is "Airi Satou"
			 And the salary of the 6th employee is "372000"
			 And there are "24" employees
			 And "Rhona Davidson" is one of the employees
			 And "21", "23", "61" are among the employee ages
		 3)Do the assertions by using Hard Assertion
	*/

    @Test
    public void get01(){
        spec03.pathParam("employeePath","employees");

        Response response = given().
                              spec(spec03).
                                 when().
                                    get("/{employeePath}");
       // response.prettyPrint();

        //1.yol
        response.
                then().
                   assertThat().
                     statusCode(200);

        response.
                then().
                  assertThat().
                     body("data.employee_name[4]",equalTo("Airi Satou"),
                         "data.employee_salary[5]",equalTo("372000"),
                              "data.employee_name",hasSize(24),
                                  "data.employee_name",hasItem("Rhona Davidson"),
                                      "data.employee_age",hasItems("21","61","23"));


        //2.yol  JsonPath ile;
        JsonPath jsonPath = response.jsonPath();

        //And the name of the 5th employee is "Airi Satou"
        Assert.assertEquals("employee name istenilen degil","Airi Satou",jsonPath.getString("data.employee_name[4]"));

        //And the salary of the 6th employee is "372000"
        Assert.assertEquals("employee salary istenilen degil","372000",jsonPath.getString("data.employee_salary[5]"));

        //And there are "24" employees
        System.out.println(jsonPath.getList("data.id"));
        Assert.assertEquals(24,jsonPath.getList("data.id").size());

        //And "Rhona Davidson" is one of the employees
        System.out.println(jsonPath.getList("data.employee_name"));
        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));


        //And "21", "23", "61" are among the employee ages
        List<String> yasListesi= new ArrayList<>();
        yasListesi.add("21");
        yasListesi.add("61");
        yasListesi.add("23");

        Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(yasListesi));





    }

}
