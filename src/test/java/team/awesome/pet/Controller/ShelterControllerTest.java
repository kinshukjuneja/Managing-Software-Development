package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.PetController;
import team.awesome.pet.controller.ShelterController;
import team.awesome.pet.model.Pet;
import team.awesome.pet.model.Shelter;
import team.awesome.pet.service.PetService;
import team.awesome.pet.service.ShelterService;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class ShelterControllerTest {
    ShelterController shelterController;
    Collection<Shelter> expected;

    @Mock
    private ShelterService mockShelterService;

    @Before
    public void init() {
        shelterController = new ShelterController();
        expected = new HashSet<>();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPets() {
        expected.add(new Shelter(new BigInteger("12345"), "Seattle-Shelter", true, 10000, "Seattle", 98005));
        Mockito.when(mockShelterService.getAllShelter()).thenReturn(expected);
        assertEquals(expected, shelterController.getAllShelter());
    }
}
