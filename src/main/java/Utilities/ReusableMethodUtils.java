package Utilities;

import DriverManagers.LoggerManager;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Map;

public class ReusableMethodUtils {
    static Logger log = LoggerManager.getLogger(ReusableMethodUtils.class);

    public static Response postMethod(String strBaseURL, String strEndPoint, Map<String, Object> header, JsonObject requestBody) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n" + strBaseURL + strEndPoint);
            log.info("\nRequest Header:\n" + header);
            log.info("\nRequest Body:\n" + requestBody);
            RestAssured.baseURI = strBaseURL;
            RequestSpecification request = RestAssured.given().log().all();
            request.headers(header);
            request.body(requestBody.toString());
            response = request.post(strEndPoint);
            log.info("\nResponse Header:\n" + response.getHeaders());
            log.info("\nResponse Body:\n" + response.getBody().asString());

        } catch (Exception e) {
            Assert.fail("post method has failed" + e.getMessage());
        }
        return response;

    }

    public static Response putMethod(String strBaseURL, String strEndPoint, Map<String, Object> header, JsonObject requestBody) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n" + strBaseURL + strEndPoint);
            log.info("\nRequest Header:\n" + header);
            log.info("\nRequest Body:\n" + requestBody);
            RestAssured.baseURI = strBaseURL;
            RequestSpecification request = RestAssured.given().log().all();
            request.headers(header);
            request.body(requestBody.toString());
            response = request.put(strEndPoint);
            log.info("\nResponse Header:\n" + response.getHeaders());
            log.info("\nResponse Body:\n" + response.getBody().asString());

        } catch (Exception e) {
            Assert.fail("put method has failed" + e.getMessage());
        }
        return response;

    }
    public static Response getMethod(String strBaseURL, String strEndPoint, Map<String, Object> header) {
        Response response = null;
        try {
            log.info("\nBase URL and EndPoint:\n"+strBaseURL+strEndPoint);
            log.info("\nRequest Header:\n"+header);
            RestAssured.baseURI=strBaseURL;
            RequestSpecification request=RestAssured.given().log().all();
            request.headers(header);
            response=request.get(strEndPoint);
            log.info("\nResponse Header:\n"+response.getHeaders());
            log.info("\nResponse Body:\n"+response.getBody().asString());

        }catch(Exception e){
            Assert.fail("get method has failed"+e.getMessage());
        }
        return response;

    }


}
