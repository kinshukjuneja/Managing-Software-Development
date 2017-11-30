package team.awesome.pet.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import team.awesome.pet.model.Pet;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetTest {
    private static final String PET_PATH = "pets";
    private static final String PET_BY_FEATURES = "/features";
    private static final String PET_NAME_PARAM = "name";
    private static final String PET_ID_PARAM = "petId";
    private static final int MIN_PETS_INSERTED = 5;
    private Pet pet;
    private JSONObject expectedPet;
    private JSONArray expectedPets;
    private int expectedStatus;
    private String testPetId;
    private String testPetName;

    public void extractPetInfo(String extractParam, String petName) throws JSONException {
        Response getResponse = CallClient.makeRequestBuilder(PET_PATH, null, null, null).get(Response.class);
        try {
            expectedPets = new JSONArray(getResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTest.class.getName()).log(Level.SEVERE, null, e);
        }
        extractPetInfoUtil(expectedPets, extractParam, petName);
    }

    public void extractPetInfoUtil(JSONArray expectedPets, String extractParam, String petName) throws JSONException {
        for(int i = 0; i < expectedPets.length(); ++i) {
            if(expectedPets.getJSONObject(i).getString(PET_NAME_PARAM).equals(petName) && petName != null) {
                testPetName = expectedPets.getJSONObject(i).getString(PET_NAME_PARAM);
            } else if(expectedPets.getJSONObject(i).get(PET_NAME_PARAM) != null && petName == null) {
                testPetName = expectedPets.getJSONObject(i).getString(PET_NAME_PARAM);
            }
            if(extractParam.equals(PET_ID_PARAM) && expectedPets.getJSONObject(i).get("name") != null) {
                testPetId = String.valueOf(expectedPets.getJSONObject(i).getString(PET_ID_PARAM));
            }
        }
    }

    @Before
    public void init() {
        CallClient.init();
        expectedStatus = 200;
        pet = Pet.builder().
                petColor("brown").
                petWeight(100).
                name("Kaizer").
                currentLocation("Seattle").
                build();
    }

    @Test
    public void testGetAllPets() throws JSONException {
        Response response = CallClient.makeRequestBuilder(PET_PATH, null, null, null).get(Response.class);
        assertEquals(expectedStatus, response.getStatus());
        try {
            expectedPets = new JSONArray(response.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertTrue(expectedPets != null && expectedPets.length() > 0);
        assertTrue(expectedPets.length() > MIN_PETS_INSERTED);
        //System.out.println(expectedPets.toString());
    }

    @Test
    public void testFindPetByFeatures() throws JSONException {
        String expectedPetName = "";
        extractPetInfo(PET_NAME_PARAM, null);
        Response response = CallClient.makeRequestBuilder(PET_PATH + PET_BY_FEATURES, PET_NAME_PARAM, null, testPetName).get(Response.class);
        assertEquals(expectedStatus, response.getStatus());
        try {
            expectedPets = new JSONArray(response.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTest.class.getName()).log(Level.SEVERE, null, e);
        }
        for(int i = 0; i < expectedPets.length(); ++i) {
            if(expectedPets.getJSONObject(i).getString(PET_NAME_PARAM) != null) {
                expectedPetName = expectedPets.getJSONObject(i).getString(PET_NAME_PARAM);
                break;
            }
        }
        assertEquals(expectedPetName, testPetName);
        //System.out.println(expectedPets.toString());
    }

    @Test
    public void testGetPetById() throws ClientErrorException, JSONException {
        extractPetInfo(PET_ID_PARAM, null);
        Response getIdResponse = CallClient.makeRequestBuilder(PET_PATH + "/" + testPetId, "id", Integer.valueOf(testPetId), null).get(Response.class);
        assertEquals(expectedStatus, getIdResponse.getStatus());
        try {
            expectedPet = new JSONObject(getIdResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertEquals(Integer.valueOf(testPetId), expectedPet.get(PET_ID_PARAM));
        //System.out.println(expectedPet.toString());
    }

    @Test
    public void testUpdatePet() throws ClientErrorException, JSONException {
        pet.setName("Bandit");
        Response updateResponse = CallClient.makeRequestBuilder(PET_PATH, null, null, null).put(Entity.json(pet));
        assertEquals(expectedStatus, updateResponse.getStatus());
        extractPetInfo(PET_NAME_PARAM, pet.getName());
        assertEquals(pet.getName(), testPetName);
    }

    @Test
    public void testInsertPet() throws ClientErrorException, JSONException {
        Response insertResponse = CallClient.makeRequestBuilder(PET_PATH, null, null, null).post(Entity.json(pet));
        assertEquals(expectedStatus, insertResponse.getStatus());
        extractPetInfo(PET_NAME_PARAM, pet.getName());
        assertEquals(pet.getName(), testPetName);
    }

    @Test
    public void testDeletePetById() throws ClientErrorException, JSONException {
        extractPetInfo(PET_ID_PARAM, null);
        Response getResponse = CallClient.makeRequestBuilder(PET_PATH, null, null, null).get(Response.class);
        JSONArray beforeDelete = new JSONArray(getResponse.readEntity(String.class));
        Response deleteResponse = CallClient.makeRequestBuilder(PET_PATH  + "/" + testPetId, "id", Integer.valueOf(testPetId), null).delete(Response.class);
        assertEquals(expectedStatus, deleteResponse.getStatus());
        Response response = CallClient.makeRequestBuilder(PET_PATH, null, null, null).get(Response.class);
        expectedPets = new JSONArray(response.readEntity(String.class));
        assertEquals(expectedStatus, deleteResponse.getStatus());
        assertTrue(beforeDelete.length() > expectedPets.length());
    }
}
