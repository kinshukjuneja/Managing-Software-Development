package team.awesome.pet.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import team.awesome.pet.model.Shelter;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShelterTest {
    private static final String SHELTER_PATH = "shelters";
    private static final String SHELTER_NAME_PARAM = "shelterName";
    private static final String SHELTER_ID_PARAM = "shelterId";
    private static final int MIN_SHELTERS_INSERTED = 5;
    private Shelter shelter;
    private JSONObject expectedShelter;
    private JSONArray expectedShelters;
    private int expectedStatus;
    private String testShelterId;
    private String testShelterName;

    public void extractShelterInfo(String extractParam, String shelterName) throws JSONException {
        Response getResponse = CallClient.makeRequestBuilder(SHELTER_PATH, null, null, null).get(Response.class);
        try {
            expectedShelters = new JSONArray(getResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(ShelterTest.class.getName()).log(Level.SEVERE, null, e);
        }
        extractShelterInfoUtil(expectedShelters, extractParam, shelterName);
    }

    public void extractShelterInfoUtil(JSONArray expectedShelters, String extractParam, String shelterName) throws JSONException {
        for(int i = 0; i < expectedShelters.length(); ++i) {
            if(expectedShelters.getJSONObject(i).getString(SHELTER_NAME_PARAM).equals(shelterName) && shelterName != null) {
                testShelterName = expectedShelters.getJSONObject(i).getString(SHELTER_NAME_PARAM);
            } else if(expectedShelters.getJSONObject(i).get(SHELTER_NAME_PARAM) != null && shelterName == null) {
                testShelterName = expectedShelters.getJSONObject(i).getString(SHELTER_NAME_PARAM);
            }
            if(extractParam.equals(SHELTER_ID_PARAM) && expectedShelters.getJSONObject(i).get("shelterName") != null) {
                testShelterId = String.valueOf(expectedShelters.getJSONObject(i).getString(SHELTER_ID_PARAM));
            }
        }
    }

    @Before
    public void init() {
        CallClient.init();
        expectedStatus = 200;
        shelter = Shelter.builder().
                shelterName("Seattle-Shelter").
                capacity(100).
                description("Lost pets").
                city("Seattle").
                status(true).
                zipCode(98121).
                build();
    }

    @Test
    public void testGetAllShelters() throws JSONException {
        Response response = CallClient.makeRequestBuilder(SHELTER_PATH, null, null, null).get(Response.class);
        assertEquals(expectedStatus, response.getStatus());
        try {
            expectedShelters = new JSONArray(response.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(ShelterTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertTrue(expectedShelters != null && expectedShelters.length() > 0);
        assertTrue(expectedShelters.length() > MIN_SHELTERS_INSERTED);
        //System.out.println(expectedShelters.toString());
    }

    @Test
    public void testGetShelterById() throws ClientErrorException, JSONException {
        extractShelterInfo(SHELTER_ID_PARAM, null);
        Response getIdResponse = CallClient.makeRequestBuilder(SHELTER_PATH + "/" + testShelterId, "id", Integer.valueOf(testShelterId), null).get(Response.class);
        assertEquals(expectedStatus, getIdResponse.getStatus());
        try {
            expectedShelter = new JSONObject(getIdResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(ShelterTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertEquals(Integer.valueOf(testShelterId), expectedShelter.get(SHELTER_ID_PARAM));
        //System.out.println(expectedShelter.toString());
    }

    @Test
    public void testUpdateShelter() throws ClientErrorException, JSONException {
        shelter.setShelterName("Dogs-Home");
        Response updateResponse = CallClient.makeRequestBuilder(SHELTER_PATH, null, null, null).put(Entity.json(shelter));
        assertEquals(expectedStatus, updateResponse.getStatus());
        extractShelterInfo(SHELTER_NAME_PARAM, shelter.getShelterName());
        assertEquals(shelter.getShelterName(), testShelterName);
    }

    @Test
    public void testInsertShelter() throws ClientErrorException, JSONException {
        Response insertResponse = CallClient.makeRequestBuilder(SHELTER_PATH, null, null, null).post(Entity.json(shelter));
        assertEquals(expectedStatus, insertResponse.getStatus());
        extractShelterInfo(SHELTER_NAME_PARAM, shelter.getShelterName());
        assertEquals(shelter.getShelterName(), testShelterName);
    }

    @Test
    public void testDeleteShelterById() throws ClientErrorException, JSONException {
        extractShelterInfo(SHELTER_ID_PARAM, null);
        Response getResponse = CallClient.makeRequestBuilder(SHELTER_PATH, null, null, null).get(Response.class);
        JSONArray beforeDelete = new JSONArray(getResponse.readEntity(String.class));
        Response deleteResponse = CallClient.makeRequestBuilder(SHELTER_PATH  + "/" + testShelterId, "id", Integer.valueOf(testShelterId), null).delete(Response.class);
        assertEquals(expectedStatus, deleteResponse.getStatus());
        Response response = CallClient.makeRequestBuilder(SHELTER_PATH, null, null, null).get(Response.class);
        expectedShelters = new JSONArray(response.readEntity(String.class));
        assertEquals(expectedStatus, deleteResponse.getStatus());
        assertTrue(beforeDelete.length() > expectedShelters.length());
    }
}
