package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.ShelterController;
import team.awesome.pet.model.Shelter;
import team.awesome.pet.service.ShelterService;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class ShelterControllerTest {
    ShelterController shelterController;

    @Mock
    private ShelterService mockShelterService;
    private Shelter shelter;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        shelterController = new ShelterController(mockShelterService);
        shelter = Shelter.builder().
                shelterId(2).
                shelterName("Seattle-Shelter").
                capacity(100).
                description("Lost pets").
                city("Seattle").
                status(true).
                zipCode(98121).
                build();
    }

    @Test
    public void testGetAllShelters() {
        Collection<Shelter> expected = new ArrayList<>();
        expected.add(shelter);
        Mockito.when(mockShelterService.getAllShelter()).thenReturn(expected);
        assertEquals(expected, shelterController.getAllShelter());
        Mockito.verify(mockShelterService, Mockito.times(1)).getAllShelter();
    }

    @Test
    public void testGetShelterById() {
        Shelter expected = shelter;
        Mockito.when(mockShelterService.getShelterById(2)).thenReturn(expected);
        assertEquals(expected, shelterController.getShelterById(2));
        Mockito.verify(mockShelterService, Mockito.times(1)).getShelterById(2);
    }

    @Test
    public void testUpdateShelter() {
        shelterController.updateShelter(shelter);
        Mockito.verify(mockShelterService, Mockito.times(1)).updateShelter(shelter);
    }

    @Test
    public void testInsertShelter() {
        shelterController.insertShelter(shelter);
        Mockito.verify(mockShelterService, Mockito.times(1)).insertShelter(shelter);
    }

    @Test
    public void testDeleteShelterById() {
        shelterController.deleteShelterById(2);
        Mockito.verify(mockShelterService, Mockito.times(1)).removeShelterById(2);
    }
}