package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.PetController;
import team.awesome.pet.model.Pet;
import team.awesome.pet.service.PetService;
import java.math.BigInteger;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetControllerTest {
    PetController petController;
    Collection<Pet> expected;

    @Mock
    private PetService mockPetService;
    Pet pet;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        petController = new PetController(mockPetService);
        pet = new Pet(1, "tommy", new BigInteger("1234567890"));
        expected = new ArrayList<>();
    }

    @Test
    public void testGetAllPets() {
        expected.add(pet);
        Mockito.when(mockPetService.getAllPets()).thenReturn(expected);
        assertEquals(expected, petController.getAllPets());
        Mockito.verify(mockPetService, Mockito.times(1)).getAllPets();
    }

    @Test
    public void testGetPetById() {
       // expected.add(pet);
        Mockito.when(mockPetService.getAllPets()).thenReturn(expected);
        for(Pet testPet: expected) {
            assertTrue(testPet.getPetId() == 1);
        }
    }

    @Test
    public void testUpdatePet() {
        Mockito.when(mockPetService.getAllPets()).thenReturn(expected);
        for(Pet updatePet: expected) {
            updatePet.setPetId(2);
        }
        for(Pet testUpdatePet: expected) {
            assertTrue(testUpdatePet.getPetId() == 2);
        }
    }

    @Test
    public void testInsertPet() {
        petController.insertPet(pet);
        Mockito.verify(mockPetService, Mockito.times(1)).insertPet(pet);
    }

    @Test
    public void testDeletePetById() {
        expected.add(pet);


    }
}
