package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.PetType;
import team.awesome.pet.service.PetTypeService;

/**
 * This represents the Controller layer for PetType which will be used as a mean to communicate to
 * the Service layer to handle all the HTTP request
 *
 */
@RestController
@RequestMapping("/pet-types")
public class PetTypeController {

  @Autowired
  private PetTypeService petTypeService;
  // private TypeRepository typeRepo;

  /**
   * HTTP GET method will return all the pet types in the existing Collection
   *
   * @return all the pet types it can find
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<PetType> getAllPetType() {
    return this.petTypeService.getAllPetType();
    // return this.typeRepo.findAll();
  }

  /**
   * HTTP GET method will return the specific pet type given the id
   *
   * @param id the integer id that will be used to find a pet type
   * @return the pet type with a matching id
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public PetType getPetTypeById(@PathVariable("id") int id) {
    return this.petTypeService.getPetTypeById(id);
    // return this.typeRepo.findOne(id);
  }

  /**
   * HTTP POST method will help to add a new pet type to the existing one
   *
   * @param petType a new pet type that needs to be added
   */
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertShelter(@RequestBody PetType petType) {
    this.petTypeService.inserPetType(petType);
    // this.typeRepo.save(petType);
  }

  /**
   * HTTP PUT method will help to update the existing pet type with new information
   *
   * @param petType a pet type that needs to be updated
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateShelter(@RequestBody PetType petType) {
    this.petTypeService.updatePetType(petType);
    // this.typeRepo.save(petType);
  }

  /**
   * HTTP DELETE method will help to delete an existing pet type given the id
   *
   * @param id an id of the pet type that will be removed from the record
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePetTypeById(@PathVariable("id") int id) {
    this.petTypeService.removePetType(id);
    // this.typeRepo.delete(id);
  }
}
