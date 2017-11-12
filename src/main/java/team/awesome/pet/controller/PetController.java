package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.Pet;
import team.awesome.pet.service.PetService;

/**
 * This represents the Controller layer for Pet which will be used as a mean to communicate to the
 * Service layer to handle all the HTTP request
 *
 */
@RestController
@RequestMapping("/pets")
public class PetController {

  @Autowired
  public PetController(PetService petService) {
    this.petService = petService;
  }

  private PetService petService;
  // private PetRepository petRepo;

  /**
   * HTTP GET method will return all the pets in the existing Collection
   *
   * @return all the pets it can find
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<Pet> getAllPets() {
    return this.petService.getAllPets();
    // return this.petRepo.findAll();
  }

  @RequestMapping(value = "/features", method = RequestMethod.GET)
  public Collection<Pet> findPetsByFeatures(
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "ownerId", required = false) String ownerId,
      @RequestParam(value = "petType", required = false) String typeId,
      @RequestParam(value = "shelterId", required = false) String shelterId,
      @RequestParam(value = "length", required = false) String length,
      @RequestParam(value = "weight", required = false) String weight,
      @RequestParam(value = "color", required = false) String color,
      @RequestParam(value = "health", required = false) String health,
      @RequestParam(value = "location", required = false) String location

  ) {
    return this.petService.findPetsByFeatures(name, ownerId, typeId, shelterId, length, weight,
        color, health, location);
  }

  /**
   * HTTP GET method will return the specific pet given the id
   *
   * @param id the integer id that will be used to find a pet
   * @return the pet with a matching id
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Pet getPetById(@PathVariable("id") int id) {
    return this.petService.getPetById(id);
    // return this.petRepo.findOne(id);
  }

  /**
   * HTTP PUT method will help to update the existing pet with new information
   *
   * @param pet a pet that needs to be updated
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updatePet(@RequestBody Pet pet) {
    this.petService.updatePet(pet);
    // this.petRepo.save(pet);
  }

  /**
   * HTTP POST method will help to add a new pet to the existing one
   *
   * @param pet a new pet that needs to be added
   */
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertPet(@RequestBody Pet pet) {
    this.petService.insertPet(pet);
    // this.petRepo.save(pet);
  }

  /**
   * HTTP DELETE method will help to delete an existing pet given the id
   *
   * @param id an id of the pet that will be removed from the record
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePetById(@PathVariable("id") int id) {
    this.petService.removePetById(id);
    // this.petRepo.delete(id);
  }

}
