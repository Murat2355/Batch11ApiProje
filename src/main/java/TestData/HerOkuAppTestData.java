package TestData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    Map<String,Object> bookingDetailsMap= new HashMap<>();
    Map<String,String> bookingdatesMap = new HashMap<>();


    public Map<String,Object> setUpData(){
        bookingdatesMap.put("checkin","2020-02-27");
        bookingdatesMap.put("checkout","2020-12-16");
        bookingDetailsMap.put("firstname","Eric");
        bookingDetailsMap.put("lastname","Ericsson");
        bookingDetailsMap.put("totalprice",612 );
        bookingDetailsMap.put("depositpaid",true);
        bookingDetailsMap.put("bookingDates",bookingdatesMap);


        return bookingDetailsMap;

    }
    public JSONObject setUpDataJSONObject(){
        JSONObject bookingDatesJSONObject = new JSONObject();
        bookingDatesJSONObject.put("checkin","2020-09-09");
        bookingDatesJSONObject.put("checkout","2020-09-21");

        JSONObject bookingDetailsJSONObject = new JSONObject();
        bookingDetailsJSONObject.put("firstname","Murat");
        bookingDetailsJSONObject.put("lastname","Ak");
        bookingDetailsJSONObject.put("totalprice",11111);
        bookingDetailsJSONObject.put("depositpaid",true);
        bookingDetailsJSONObject.put("bookingdates",bookingDatesJSONObject);

        return bookingDetailsJSONObject;

    }
}
