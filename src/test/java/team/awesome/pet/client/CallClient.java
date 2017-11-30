package team.awesome.pet.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

public class CallClient {
    private static Client client = ClientBuilder.newClient();;
    private final static String BASE_URI = "https://petrescueorganization.herokuapp.com/";
    public  static WebTarget webTarget;
    private static Map<String, String> cookies;
    private static final String COOKIE_TYPE = "JSESSIONID";
    private static final String COOKIE_ID = "06DCF914B6BE40E7A7134D157D0E8919";

    public static Invocation.Builder makeRequestBuilder(String entityPath, String paramType, Integer paramId, String paramName) {
        Invocation.Builder build = paramType == null ?
                CallClient.webTarget.path(entityPath).request(MediaType.APPLICATION_JSON) :
                paramId == null ? CallClient.webTarget.path(entityPath).queryParam(paramType, paramName).request(MediaType.APPLICATION_JSON) :
                        CallClient.webTarget.path(entityPath).queryParam(paramType, paramId).request(MediaType.APPLICATION_JSON);
        for(String type : cookies.keySet()) {
            build.cookie(type, cookies.get(type));
        }
        return build;
    }

    public static void init() {
        webTarget = client.target(BASE_URI);
        // Make a login request
        // Extract JSESSIONID token from cookies
        // Store that somewhere
        // Pass a JSESSIONID cookie parameter every request
        cookies = new HashMap<>();
        cookies.put(COOKIE_TYPE, COOKIE_ID);
    }
}

