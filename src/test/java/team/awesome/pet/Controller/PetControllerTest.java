package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.PetController;
import team.awesome.pet.model.Pet;
import team.awesome.pet.model.PetType;
import team.awesome.pet.model.User;
import team.awesome.pet.service.PetService;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class PetControllerTest {
    PetController petController;

    @Mock
    private PetService mockPetService;
    private Pet pet;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController(mockPetService);
        pet = Pet.builder().
                petId(1).
                petColor("brown").
                petLength(12.5).
                petWeight(100).
                name("Kaizer").
                currentLocation("Seattle").
                owner(new User()).
                petType(new PetType()).
                build();
    }

    @Test
    public void testGetAllPets() {
        Collection<Pet> expected = new ArrayList<>();
        expected.add(pet);
        Mockito.when(mockPetService.getAllPets()).thenReturn(expected);
        assertEquals(expected, petController.getAllPets());
        Mockito.verify(mockPetService, Mockito.times(1)).getAllPets();
    }

    @Test
    public void testGetPetById() {
        Pet expected = pet;
        Mockito.when(mockPetService.getPetById(1)).thenReturn(expected);
        assertEquals(expected, petController.getPetById(1));
        Mockito.verify(mockPetService, Mockito.times(1)).getPetById(1);
    }

    @Test
    public void testUpdatePet() {
        petController.updatePet(pet);
        Mockito.verify(mockPetService, Mockito.times(1)).updatePet(pet);
    }
    @Test
    public void testInsertPet() {
        petController.insertPet(pet);
        Mockito.verify(mockPetService, Mockito.times(1)).insertPet(pet);
    }

    @Test
    public void testDeletePetById() {
        petController.deletePetById(1);
        Mockito.verify(mockPetService, Mockito.times(1)).removePetById(1);
    }

    @Test
    public void testfindPetsByFeatures() {
        Collection<Pet> expected = new ArrayList<>();
        expected.add(pet);
        Mockito.when(mockPetService.findPetsByFeatures("Kaizer", null, null, null, null, null, "brown", null, null)).thenReturn(expected);
        assertEquals(expected, petController.findPetsByFeatures("Kaizer", null, null, null, null, null, "brown", null, null));
        Mockito.verify(mockPetService, Mockito.times(1)).findPetsByFeatures("Kaizer", null, null, null, null, null, "brown", null, null);
    }
}