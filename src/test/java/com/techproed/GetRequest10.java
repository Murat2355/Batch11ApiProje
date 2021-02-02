package com.techproed;

import TestBase.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest10 extends TestBaseDummy {
    /*
	 When
		 I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console--10 dan buuyk id leri yazininz
		   Assert that there are 14 ids greater than 10 --id si 10 dan buyuk 14 data oldugunu test edin
		 2)Print all ages less than 30 on the console--yaslari 30 dan buyuk olan datalari consolde yazdiriniz
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350,000
		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
	 */

    @Test
    public void get01(){
        spec03.pathParam("employeePath","employees");

        Response response = given().
                               spec(spec03).
                                   when().
                                      get("/{employeePath}");

        //response.prettyPrint();
        response.
                then().
                   assertThat().
                      statusCode(200);

        SoftAssert softAssert = new SoftAssert();

        //Groovy Language
        //Javanin alt dili

        JsonPath json = response.jsonPath();
        //it--this gorevi gorur--->bu datanin icindeki
        List<String> idListesi = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idListesi);

        softAssert.assertEquals(idListesi.size(),14);


        List<String> ageList = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);

        List<Integer> ageListInt = new ArrayList<>();
        for (String w:ageList) {
            ageListInt.add(Integer.valueOf(w));
        }

        System.out.println(ageListInt);
        Collections.sort(ageListInt);
        softAssert.assertEquals(Integer.valueOf("23"),ageListInt.get(ageListInt.size()-1));


        List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(nameList);

        softAssert.assertTrue(nameList.contains("Charde Marshall"));


        softAssert.assertAll();
    }
}
