package team.awesome.pet.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import team.awesome.pet.model.User;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    private static final String USER_PATH = "user";
    private static final String USER_NAME_PARAM = "username";
    private static final String USER_ID_PARAM = "id";
    private static final int MIN_USERS_INSERTED = 5;
    private User user;
    private JSONObject expectedUser;
    private JSONArray expectedUsers;
    private int expectedStatus;
    private String testUserId;
    private String testUserName;

    public void extractUserInfo(String extractParam, String username) throws JSONException {
        Response getResponse = CallClient.makeRequestBuilder(USER_PATH, null, null, null).get(Response.class);
        try {
            expectedUsers = new JSONArray(getResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, e);
        }
        extractUserInfoUtil(expectedUsers, extractParam, username);
    }

    public void extractUserInfoUtil(JSONArray expectedUsers, String extractParam, String username) throws JSONException {
        for(int i = 0; i < expectedUsers.length(); ++i) {
            if(expectedUsers.getJSONObject(i).getString(USER_NAME_PARAM).equals(username) && username != null) {
                testUserName = expectedUsers.getJSONObject(i).getString(USER_NAME_PARAM);
            } else if(expectedUsers.getJSONObject(i).get(USER_NAME_PARAM) != null && username == null) {
                testUserName = expectedUsers.getJSONObject(i).getString(USER_NAME_PARAM);
            }
            if(extractParam.equals(USER_ID_PARAM) && expectedUsers.getJSONObject(i).get("username") != null) {
                testUserId = String.valueOf(expectedUsers.getJSONObject(i).getString(USER_ID_PARAM));
            }
        }
    }

    @Before
    public void init() {
        CallClient.init();
        expectedStatus = 200;
        user = User.builder().
                userName("Kinsh").
                address("Seattle").
                email("askkinsh@gmail.com").
                firstName("Kinshuk").
                lastName("Juneja").
                password("S3cret").
                phone(2066040324).
                build();
    }

    @Test
    public void testGetAllUsers() throws JSONException {
        Response response = CallClient.makeRequestBuilder(USER_PATH, null, null, null).get(Response.class);
        assertEquals(expectedStatus, response.getStatus());
        try {
            expectedUsers = new JSONArray(response.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertTrue(expectedUsers != null && expectedUsers.length() > 0);
        assertTrue(expectedUsers.length() > MIN_USERS_INSERTED);
        //System.out.println(expectedUsers.toString());
    }

    @Test
    public void testGetUserById() throws ClientErrorException, JSONException {
        extractUserInfo(USER_ID_PARAM, null);
        Response getIdResponse = CallClient.makeRequestBuilder(USER_PATH + "/" + testUserId, "id", Integer.valueOf(testUserId), null).get(Response.class);
        assertEquals(expectedStatus, getIdResponse.getStatus());
        try {
            expectedUser = new JSONObject(getIdResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(UserTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertEquals(Integer.valueOf(testUserId), expectedUser.get(USER_ID_PARAM));
        //System.out.println(expectedUser.toString());
    }

    @Test
    public void testUpdateUser() throws ClientErrorException, JSONException {
        user.setUsername("Dogs-Home");
        Response updateResponse = CallClient.makeRequestBuilder(USER_PATH, null, null, null).put(Entity.json(user));
        assertEquals(expectedStatus, updateResponse.getStatus());
        extractUserInfo(USER_NAME_PARAM, user.getUsername());
        assertEquals(user.getUsername(), testUserName);
    }

    @Test
    public void testInsertUser() throws ClientErrorException, JSONException {
        Response insertResponse = CallClient.makeRequestBuilder(USER_PATH, null, null, null).post(Entity.json(user));
        assertEquals(expectedStatus, insertResponse.getStatus());
        extractUserInfo(USER_NAME_PARAM, user.getUsername());
        assertEquals(user.getUsername(), testUserName);
    }

    @Test
    public void testDeleteUserById() throws ClientErrorException, JSONException {
        extractUserInfo(USER_ID_PARAM, null);
        Response getResponse = CallClient.makeRequestBuilder(USER_PATH, null, null, null).get(Response.class);
        JSONArray beforeDelete = new JSONArray(getResponse.readEntity(String.class));
        Response deleteResponse = CallClient.makeRequestBuilder(USER_PATH  + "/" + testUserId, "id", Integer.valueOf(testUserId), null).delete(Response.class);
        assertEquals(expectedStatus, deleteResponse.getStatus());
        Response response = CallClient.makeRequestBuilder(USER_PATH, null, null, null).get(Response.class);
        expectedUsers = new JSONArray(response.readEntity(String.class));
        assertEquals(expectedStatus, deleteResponse.getStatus());
        assertTrue(beforeDelete.length() > expectedUsers.length());
    }
}
