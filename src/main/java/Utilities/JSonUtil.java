package Utilities;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSonUtil {

    //Object Method kullanilarak De-Serialization yapma methode

    private static org.codehaus.jackson.map.ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    //Methodumuzu olusturacagiz: Json datasini Java objesine donusturecek
    public static <T>T convertJsonToJava(String json,Class<T> cls) {
        T javaResult = null;

        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            System.err.println("Json Datasini Java'ya donusturemedi" + e.getMessage());
        }
        return javaResult ;

    }
}
