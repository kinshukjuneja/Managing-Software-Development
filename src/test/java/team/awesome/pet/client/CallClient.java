package team.awesome.pet.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class UseClient {
    private static Client client = ClientBuilder.newClient();
    private final static String BASE_URI = "https://petrescueorganization.herokuapp.com/";
    public  static WebTarget webTarget = client.target(BASE_URI);
}

