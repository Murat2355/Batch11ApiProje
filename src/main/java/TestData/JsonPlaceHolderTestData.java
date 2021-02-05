package TestData;

import java.util.HashMap;

public class JsonPlaceHolderTestData {
    public HashMap<String,Object> expectedDataMap ;

    public HashMap<String,Object> setUpData(){

        expectedDataMap = new HashMap<String, Object>();
        expectedDataMap.put("Status Code",200);
        expectedDataMap.put("userId",10);
        expectedDataMap.put("title","quis eius est sint explicabo");
        expectedDataMap.put("completed",true);
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");
        return expectedDataMap;

    }
}