package com.techproed;

import TestBase.TestBaseDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetRequest08 extends TestBaseDummy {
     /*
        Url: "http://dummy.restapiexample.com/api/v1/employees
        1) Butun calisanlarin isimlerini consola yazdır
        2) 3. calisan kisinin ismini konsola yazdır
        3) Ilk 5 calisanin adini konsola yazdir
        4) En son calisanin adini konsola yazdir.
     */

    @Test
    public void get01(){
        //url olustur
        spec03.pathParam("employees","employees");

        Response response = given().
                              spec(spec03).
                                 when().
                                    get("/{employees}");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        //1) Butun calisanlarin isimlerini consola yazdır
        System.out.println(jsonPath.getString("data.employee_name"));

        //calisanlarin maaslarini yazdiriniz
        System.out.println(jsonPath.getString("data.employee_salary"));

        // 3. calisan kisinin ismini konsola yazdır
        System.out.println(jsonPath.getString("data.employee_name[2]"));
        // Ilk 5 calisanin adini konsola yazdir
        System.out.println(jsonPath.getString("data.employee_name[0,1,2,3,4]"));

        // En son calisanin adini konsola yazdir.
        System.out.println(jsonPath.getString("data.employee_name[23]"));


    }
}
