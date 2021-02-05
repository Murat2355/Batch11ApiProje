package TestData;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyTestDataDeneme {

     /*
      When
      I send get request to yje URL http://dummy.restapiexample.com/api/v1/employees
      Then
      Status Code 200
      5. calisanin ismi "Airi Satou"
      Calisan sayisi 24
      Sondan ikinci calisanin maasi "106450"
      23,21 ve 19 yaslarinda calisanlar olup olmadıgı
      11. calisanin bilgileri {              "id": "11",
                                            "employee_name": "Jena Gaines",
                                            "employee_salary": "90560",
                                            "employee_age": "30",
                                            "profile_image": ""
                                             }
                                            seklinde mi
                                            Assert edelim.

      */

    public List<Map<String,Object>> expectedDataList = new ArrayList<>();
    public List<Map<String,Object>> setUpData(){

        HashMap<String,Object> expectedData1 = new HashMap<>();
        expectedData1.put("Status Code",200);
        expectedDataList.add(expectedData1);

        HashMap<String,Object> expectedData2 = new HashMap<>();
        expectedData2.put("SecilenEmployeenaName","Airi Satou");
        expectedDataList.add(expectedData2);

        HashMap<String,Object> expectedData3 = new HashMap<>();
        expectedData3.put("CalisanSayisi", 24);
        expectedDataList.add(expectedData3);

        HashMap<String,Object> expectedData4 = new HashMap<>();
        expectedData4.put("CalisanMaasi", "106450");
        expectedDataList.add(expectedData4);

        List<String> yasListesi = new ArrayList<>();
        yasListesi.add("23");
        yasListesi.add("21");
        yasListesi.add("19");
        HashMap<String,Object> expectedData5 = new HashMap<>();
        expectedData5.put("YasaGoreSecilenCalisanlar",yasListesi);
        expectedDataList.add(expectedData5);

        Map<String,String> calisanBilgileri = new HashMap<>();
        calisanBilgileri.put("id","11");
        calisanBilgileri.put("employee_name","Jena Gaines");
        calisanBilgileri.put("employee_salary","90560");
        calisanBilgileri.put("employee_age","30");
        calisanBilgileri.put("profile_image","");
        HashMap<String,Object> expectedData6 = new HashMap<>();
        expectedData6.put("CalisaninTumBilgileri",calisanBilgileri);
        expectedDataList.add(expectedData6);

        return expectedDataList;

    }
}
