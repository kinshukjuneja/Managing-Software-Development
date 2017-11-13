package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.PetTypeController;
import team.awesome.pet.service.PetTypeService;
import team.awesome.pet.model.PetType;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class PetTypeControllerTest {
    PetTypeController petTypeController;

    @Mock
    private PetTypeService mockPetTypeService;
    private PetType petType;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        petTypeController = new PetTypeController(mockPetTypeService);
        petType = PetType.builder().
                type("German Shepherd ").
                typeId(20).
                category("Dog").
                build();
    }

    @Test
    public void testGetAllPetType() {
        Collection<PetType> expected = new ArrayList<>();
        expected.add(petType);
        Mockito.when(mockPetTypeService.getAllPetType()).thenReturn(expected);
        assertEquals(expected, petTypeController.getAllPetType());
        Mockito.verify(mockPetTypeService, Mockito.times(1)).getAllPetType();
    }

    @Test
    public void testGetPetTypeById() {
        PetType expected = petType;
        Mockito.when(mockPetTypeService.getPetTypeById(20)).thenReturn(expected);
        assertEquals(expected, petTypeController.getPetTypeById(20));
        Mockito.verify(mockPetTypeService, Mockito.times(1)).getPetTypeById(20);
    }

    @Test
    public void testUpdatePetType() {
        petTypeController.updateShelter(petType);
        Mockito.verify(mockPetTypeService, Mockito.times(1)).updatePetType(petType);
    }
    @Test
    public void testInsertPetType() {
        petTypeController.insertShelter(petType);
        Mockito.verify(mockPetTypeService, Mockito.times(1)).inserPetType(petType);
    }

    @Test
    public void testDeletePetTypeById() {
        petTypeController.deletePetTypeById(20);
        Mockito.verify(mockPetTypeService, Mockito.times(1)).removePetType(20);
    }
}