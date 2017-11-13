package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.TrackController;
import team.awesome.pet.model.Pet;
import team.awesome.pet.model.Track;
import team.awesome.pet.service.TrackService;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class TrackControllerTest {
    TrackController trackController;

    @Mock
    private TrackService mockTrackService;
    private Track track;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Pet pet = new Pet();
        pet.setPetId(1);
        trackController = new TrackController(mockTrackService);
        track = Track.builder().
                trackId(15).
                pet(pet).
                recordLocation("Seattle").
                recordTime(new Date()).
                build();
    }

    @Test
    public void testGetAllTracks() {
        Collection<Track> expected = new ArrayList<>();
        expected.add(track);
        Mockito.when(mockTrackService.getAllTracks()).thenReturn(expected);
        assertEquals(expected, trackController.getAllTracks());
        Mockito.verify(mockTrackService, Mockito.times(1)).getAllTracks();
    }

    @Test
    public void testGetTrackById() {
        Track expected = track;
        Mockito.when(mockTrackService.getTrackById(15)).thenReturn(expected);
        assertEquals(expected, trackController.getTrackById(15));
        Mockito.verify(mockTrackService, Mockito.times(1)).getTrackById(15);
    }

    @Test
    public void testFindTrackByPet() {
        Collection<Track> expected = new ArrayList<>();
        expected.add(track);
        Mockito.when(mockTrackService.findTrackByPet(1)).thenReturn((List<Track>) expected);
        assertEquals(expected, trackController.findTrackByPet(1));
        Mockito.verify(mockTrackService, Mockito.times(1)).findTrackByPet(1);
    }

    @Test
    public void testUpdateTrack() {
        trackController.updateTrack(track);
        Mockito.verify(mockTrackService, Mockito.times(1)).updateTrack(track);
    }

    @Test
    public void testInsertTrack() {
        trackController.insertTrack(track);
        Mockito.verify(mockTrackService, Mockito.times(1)).insertTrack(track);
    }

    @Test
    public void testDeleteTrackById() {
        trackController.deleteTrackById(15);
        Mockito.verify(mockTrackService, Mockito.times(1)).removeTrack(15);
    }
}