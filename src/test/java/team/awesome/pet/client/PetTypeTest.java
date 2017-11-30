package team.awesome.pet.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import team.awesome.pet.model.PetType;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetTypeTest {
    private static final String PET_TYPE_PATH = "pet-types";
    private static final String PET_TYPE_NAME_PARAM = "type";
    private static final String PET_TYPE_ID_PARAM = "typeId";
    private static final int MIN_PET_TYPES_INSERTED = 2;
    private PetType petType;
    private JSONObject expectedPetType;
    private JSONArray expectedPetTypes;
    private int expectedStatus;
    private String testPetTypeId;
    private String testPetTypeName;

    public void extractPetTypeInfo(String extractParam, String type) throws JSONException {
        Response getResponse = CallClient.makeRequestBuilder(PET_TYPE_PATH, null, null, null).get(Response.class);
        try {
            expectedPetTypes = new JSONArray(getResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTypeTest.class.getName()).log(Level.SEVERE, null, e);
        }
        extractPetTypeInfoUtil(expectedPetTypes, extractParam, type);
    }

    public void extractPetTypeInfoUtil(JSONArray expectedPetTypes, String extractParam, String type) throws JSONException {
        for(int i = 0; i < expectedPetTypes.length(); ++i) {
            if(expectedPetTypes.getJSONObject(i).getString(PET_TYPE_NAME_PARAM).equals(type) && type != null) {
                testPetTypeName = expectedPetTypes.getJSONObject(i).getString(PET_TYPE_NAME_PARAM);
            } else if(expectedPetTypes.getJSONObject(i).get(PET_TYPE_NAME_PARAM) != null && type == null) {
                testPetTypeName = expectedPetTypes.getJSONObject(i).getString(PET_TYPE_NAME_PARAM);
            }
            if(extractParam.equals(PET_TYPE_ID_PARAM) && expectedPetTypes.getJSONObject(i).get("type") != null) {
                testPetTypeId = String.valueOf(expectedPetTypes.getJSONObject(i).getString(PET_TYPE_ID_PARAM));
            }
        }
    }

    @Before
    public void init() {
        CallClient.init();
        expectedStatus = 200;
        petType = PetType.builder().
                type("German Shepherd ").
                typeId(20).
                category("Dog").
                build();
    }

    @Test
    public void testGetAllPetTypes() throws JSONException {
        Response response = CallClient.makeRequestBuilder(PET_TYPE_PATH, null, null, null).get(Response.class);
        assertEquals(expectedStatus, response.getStatus());
        try {
            expectedPetTypes = new JSONArray(response.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTypeTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertTrue(expectedPetTypes != null && expectedPetTypes.length() > 0);
        assertTrue(expectedPetTypes.length() > MIN_PET_TYPES_INSERTED);
        //System.out.println(expectedPetTypes.toString());
    }

    @Test
    public void testGetPetTypeById() throws ClientErrorException, JSONException {
        extractPetTypeInfo(PET_TYPE_ID_PARAM, null);
        Response getIdResponse = CallClient.makeRequestBuilder(PET_TYPE_PATH + "/" + testPetTypeId, "id", Integer.valueOf(testPetTypeId), null).get(Response.class);
        assertEquals(expectedStatus, getIdResponse.getStatus());
        try {
            expectedPetType = new JSONObject(getIdResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(PetTypeTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertEquals(Integer.valueOf(testPetTypeId), expectedPetType.get(PET_TYPE_ID_PARAM));
        //System.out.println(expectedPetType.toString());
    }

    @Test
    public void testUpdatePetType() throws ClientErrorException, JSONException {
        petType.setType("Dogs-Home");
        Response updateResponse = CallClient.makeRequestBuilder(PET_TYPE_PATH, null, null, null).put(Entity.json(petType));
        assertEquals(expectedStatus, updateResponse.getStatus());
        extractPetTypeInfo(PET_TYPE_NAME_PARAM, petType.getType());
        assertEquals(petType.getType(), testPetTypeName);
    }

    @Test
    public void testInsertPetType() throws ClientErrorException, JSONException {
        Response insertResponse = CallClient.makeRequestBuilder(PET_TYPE_PATH, null, null, null).post(Entity.json(petType));
        assertEquals(expectedStatus, insertResponse.getStatus());
        extractPetTypeInfo(PET_TYPE_NAME_PARAM, petType.getType());
        assertEquals(petType.getType(), testPetTypeName);
    }

    @Test
    public void testDeletePetTypeById() throws ClientErrorException, JSONException {
        extractPetTypeInfo(PET_TYPE_ID_PARAM, null);
        Response getResponse = CallClient.makeRequestBuilder(PET_TYPE_PATH, null, null, null).get(Response.class);
        JSONArray beforeDelete = new JSONArray(getResponse.readEntity(String.class));
        Response deleteResponse = CallClient.makeRequestBuilder(PET_TYPE_PATH  + "/" + testPetTypeId, "id", Integer.valueOf(testPetTypeId), null).delete(Response.class);
        assertEquals(expectedStatus, deleteResponse.getStatus());
        Response response = CallClient.makeRequestBuilder(PET_TYPE_PATH, null, null, null).get(Response.class);
        expectedPetTypes = new JSONArray(response.readEntity(String.class));
        assertEquals(expectedStatus, deleteResponse.getStatus());
        assertTrue(beforeDelete.length() > expectedPetTypes.length());
    }
}
