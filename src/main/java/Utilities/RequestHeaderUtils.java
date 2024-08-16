package Utilities;

import java.util.HashMap;
import java.util.Map;

public class RequestHeaderUtils {
    public static Map<String, Object> getBasicHeader(){
        Map<String,Object> headers=new HashMap<>();
        headers.put("accept","application/json");
        headers.put("Authorization","Bearer eyJ0o");//add ur token
        headers.put("Content-Type","application/json");
        return headers;

    }
}
