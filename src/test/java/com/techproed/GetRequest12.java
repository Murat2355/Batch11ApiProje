package com.techproed;

import TestBase.TestBaseDummy;
import TestData.DummyTestData;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetRequest12 extends TestBaseDummy {
    /*
      When
      I send get request to yje URL http://dummy.restapiexample.com/api/v1/employees
      Then
      Status Code 200
      5. calisanin ismi "Airi Satou"
      Calisan sayisi 24
      Sondan ikinci calisanin maasi "106450"
      40,21 ve 19 yaslarinda calisanlar olup olmadıgı
      11. calisanin bilgileri {              "id": "11",
                                            "employee_name": "Jena Gaines",
                                            "employee_salary": "90560",
                                            "employee_age": "30",
                                            "profile_image": ""
                                             }
                                            seklinde mi
                                            Assert edelim.

     */
    @Test
    public void get01(){
        // 1. Url olusturmak
        spec03.pathParam("employees","employees");

        //2. Expected(beklenen) datayı olustur
        DummyTestData expectedObj = new DummyTestData();
        List<Map<String,Object>> expectedDataList = expectedObj.setUpData();
        System.out.println(expectedDataList);
        //3. Request i gonder
        Response response = given().
                spec(spec03).
                when().
                get("/{employees}");
        response.prettyPrint();

        // 1. yol body ile
        response.
                then().
                assertThat().
                statusCode((Integer)expectedDataList.get(0).get("Status Code")).
                body("data[4].employee_name", Matchers.equalTo(expectedDataList.get(1).get("SelectedEmployeeName")),
                        "data.id",Matchers.hasSize((Integer)expectedDataList.get(2).get("NumOfEmployees")),
                        "data[-2].employee_salary",Matchers.equalTo(expectedDataList.get(3).get("SelectedSalary")),
                        "data.employee_age",Matchers.hasItems(((List)expectedDataList.get(4).get("MultipleAges")).get(0),
                                ((List)expectedDataList.get(4).get("MultipleAges")).get(1),
                                ((List)expectedDataList.get(4).get("MultipleAges")).get(2)),
                        "data[10].employee_name",Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_name")),
                        "data[10].employee_salary",Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_salary")),
                        "data[10].employee_age",Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("employee_age")) ,
                        "data[10].profile_image",Matchers.equalTo(((Map)expectedDataList.get(5).get("AllDetailsAboutEmployee")).get("profile_image")));



    }
}