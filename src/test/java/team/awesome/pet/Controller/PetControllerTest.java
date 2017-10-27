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
import java.util.Collection;
import java.util.HashSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PetControllerTest {
    PetController petController;
    Collection<Pet> expected;

    @Mock
    private PetService mockPetService;

    @Before
    public void init() {
        petController = new PetController();
        expected = new HashSet<>();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPets() {
        expected.add(new Pet(1, "woof", new BigInteger("1234567890")));
        Mockito.when(mockPetService.getAllPets()).thenReturn(expected);
        assertEquals(expected, petController.getAllPets());
    }
}
