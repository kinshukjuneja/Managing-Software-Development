package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.PetController;
import team.awesome.pet.model.Pet;
import team.awesome.pet.service.PetService;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class PetControllerTest {
    PetController petController;

    @Mock
    private PetService mockPetService;
    Pet pet;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController(mockPetService);
        pet = new Pet();
        pet.setName("Kaizer");
        pet.setPetId(1);
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
}