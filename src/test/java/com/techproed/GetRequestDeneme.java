package com.techproed;

import TestBase.TestBaseDummy;
import TestData.DummyTestDataDeneme;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetRequestDeneme extends TestBaseDummy {
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
        //1.url olustur
        spec03.pathParam("employees","employees");

        //2.Data olustur
        DummyTestDataDeneme expectedDataObjesi = new DummyTestDataDeneme();
        List<Map<String,Object>> expectedDataList = expectedDataObjesi.setUpData();
        System.out.println(expectedDataList);

        //Request olusturma
        Response response = given().
                                   spec(spec03).
                                            when().
                                                   get("/{employees}");


        response.prettyPrint();

        response.then().
                   assertThat().
                       statusCode((Integer)expectedDataList.get(0).get("Status Code")).
                          body("data[4].employee_name",equalTo(expectedDataList.get(1).get("SecilenEmployeenaName")),
                                  "data.id",hasSize((Integer)expectedDataList.get(2).get("CalisanSayisi")),
                                  "data.employee_salary[-2]",equalTo(expectedDataList.get(3).get("CalisanMaasi")),
                                  "data.employee_age",hasItems(((List)expectedDataList.get(4).get("YasaGoreSecilenCalisanlar")).get(0),
                                          ((List)expectedDataList.get(4).get("YasaGoreSecilenCalisanlar")).get(1),
                                          ((List)expectedDataList.get(4).get("YasaGoreSecilenCalisanlar")).get(2)),
                                          "data[10].employee_name",equalTo(((Map)expectedDataList.get(5).get("CalisaninTumBilgileri")).get("employee_name")),
                                          "data[10].employee_salary",equalTo(((Map)expectedDataList.get(5).get("CalisaninTumBilgileri")).get("employee_salary")),
                                          "data[10].id",equalTo(((Map)expectedDataList.get(5).get("CalisaninTumBilgileri")).get("id")),
                                          "data[10].employee_age",equalTo(((Map)expectedDataList.get(5).get("CalisaninTumBilgileri")).get("employee_age")),
                                          "data[10].profile_image",equalTo(((Map)expectedDataList.get(5).get("CalisaninTumBilgileri")).get("profile_image")));
    }
}
