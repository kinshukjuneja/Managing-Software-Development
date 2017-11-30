package team.awesome.pet.client;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import team.awesome.pet.model.Pet;
import team.awesome.pet.model.Track;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrackTest {
    private static final String TRACK_PATH = "tracks";
    private static final String TRACK_NAME_PARAM = "recordTime";
    private static final String TRACK_ID_PARAM = "trackId";
    private static final int MIN_TRACKS_INSERTED = 2;
    private Track track;
    private Pet pet;
    private JSONObject expectedTrack;
    private JSONArray expectedTracks;
    private int expectedStatus;
    private String testTrackId;
    private String testTrackName;

    public void extractTrackInfo(String extractParam, String trackName) throws JSONException {
        Response getResponse = CallClient.makeRequestBuilder(TRACK_PATH, null, null, null).get(Response.class);
        try {
            expectedTracks = new JSONArray(getResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(TrackTest.class.getName()).log(Level.SEVERE, null, e);
        }
        extractTrackInfoUtil(expectedTracks, extractParam, trackName);
    }

    public void extractTrackInfoUtil(JSONArray expectedTracks, String extractParam, String trackName) throws JSONException {
        for(int i = 0; i < expectedTracks.length(); ++i) {
            if(expectedTracks.getJSONObject(i).getString(TRACK_NAME_PARAM).equals(trackName) && trackName != null) {
                testTrackName = expectedTracks.getJSONObject(i).getString(TRACK_NAME_PARAM);
            } else if(expectedTracks.getJSONObject(i).get(TRACK_NAME_PARAM) != null && trackName == null) {
                testTrackName = expectedTracks.getJSONObject(i).getString(TRACK_NAME_PARAM);
            }
            if(extractParam.equals(TRACK_ID_PARAM) && expectedTracks.getJSONObject(i).get("trackId") != null) {
                testTrackId = String.valueOf(expectedTracks.getJSONObject(i).getString(TRACK_ID_PARAM));
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
        track = Track.builder().
                pet(pet).
                recordLocation("55").
                recordTime(new Date()).
                build();
    }

    @Test
    public void testGetAllTracks() throws JSONException {
        Response response = CallClient.makeRequestBuilder(TRACK_PATH, null, null, null).get(Response.class);
        assertEquals(expectedStatus, response.getStatus());
        try {
            expectedTracks = new JSONArray(response.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(TrackTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertTrue(expectedTracks != null && expectedTracks.length() > 0);
        assertTrue(expectedTracks.length() > MIN_TRACKS_INSERTED);
        System.out.println(expectedTracks.toString());
    }

    @Test
    public void testGetTrackById() throws ClientErrorException, JSONException {
        extractTrackInfo(TRACK_ID_PARAM, null);
        Response getIdResponse = CallClient.makeRequestBuilder(TRACK_PATH + "/" + testTrackId, "id", Integer.valueOf(testTrackId), null).get(Response.class);
        assertEquals(expectedStatus, getIdResponse.getStatus());
        try {
            expectedTrack = new JSONObject(getIdResponse.readEntity(String.class));
        } catch (JSONException e) {
            Logger.getLogger(TrackTest.class.getName()).log(Level.SEVERE, null, e);
        }
        assertEquals(Integer.valueOf(testTrackId), expectedTrack.get(TRACK_ID_PARAM));
        //System.out.println(expectedTrack.toString());
    }

    @Test
    public void testUpdateTrack() throws ClientErrorException, JSONException {
        track.setRecordLocation("50");
        Response updateResponse = CallClient.makeRequestBuilder(TRACK_PATH, null, null, null).put(Entity.json(track));
        assertEquals(expectedStatus, updateResponse.getStatus());
        extractTrackInfo(TRACK_NAME_PARAM, track.getRecordLocation());
        assertEquals(track.getRecordLocation(), testTrackName);
    }

    @Test
    public void testInsertTrack() throws ClientErrorException, JSONException {
        Response insertResponse = CallClient.makeRequestBuilder(TRACK_PATH, null, null, null).post(Entity.json(track));
        assertEquals(expectedStatus, insertResponse.getStatus());
        extractTrackInfo(TRACK_NAME_PARAM, track.getRecordLocation());
        assertEquals(track.getRecordLocation(), testTrackName);
    }

    @Test
    public void testDeleteTrackById() throws ClientErrorException, JSONException {
        extractTrackInfo(TRACK_ID_PARAM, null);
        Response getResponse = CallClient.makeRequestBuilder(TRACK_PATH, null, null, null).get(Response.class);
        JSONArray beforeDelete = new JSONArray(getResponse.readEntity(String.class));
        Response deleteResponse = CallClient.makeRequestBuilder(TRACK_PATH  + "/" + testTrackId, "id", Integer.valueOf(testTrackId), null).delete(Response.class);
        assertEquals(expectedStatus, deleteResponse.getStatus());
        Response response = CallClient.makeRequestBuilder(TRACK_PATH, null, null, null).get(Response.class);
        expectedTracks = new JSONArray(response.readEntity(String.class));
        assertEquals(expectedStatus, deleteResponse.getStatus());
        assertTrue(beforeDelete.length() > expectedTracks.length());
    }
}
