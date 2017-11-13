package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.Shelter;
import team.awesome.pet.service.PetService;
import team.awesome.pet.service.ShelterService;

/**
 * This represents the Controller layer for Shelter which will be used as a mean to communicate to
 * the Service layer to handle all the HTTP request
 *
 */
@RestController
@RequestMapping("/shelters")
public class ShelterController {
  @Autowired
  private ShelterService shelterService;
  // private ShelterRepository shelterRepo;

  public ShelterController(ShelterService shelterService) {
    this.shelterService = shelterService;
  }

  /**
   * HTTP GET method will return all the shelters in the existing Collection
   *
   * @return all the shelters it can find
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<Shelter> getAllShelter() {
    return this.shelterService.getAllShelter();
    // return this.shelterRepo.findAll();
  }

  /**
   * HTTP GET method will return the specific shelter given the id
   *
   * @param id the integer id that will be used to find a shelter
   * @return the shelter with a matching id
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Shelter getShelterById(@PathVariable("id") int id) {
    return this.shelterService.getShelterById(id);
    // return this.shelterRepo.findOne(id);
  }

  /**
   * HTTP POST method will help to add a new shelter to the existing one
   *
   * @param shelter that needs to be added
   */
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertShelter(@RequestBody Shelter shelter) {
    this.shelterService.insertShelter(shelter);
    // this.shelterRepo.save(shelter);
  }

  /**
   * HTTP PUT method will help to update the existing shelter with new information
   *
   * @param shelter a shelter that needs to be updated
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateShelter(@RequestBody Shelter shelter) {
    this.shelterService.updateShelter(shelter);
    // this.shelterRepo.save(shelter);
  }

  /**
   * HTTP DELETE method will help to delete an existing shelter given the id
   *
   * @param id an id of the shelter that will be removed from the record
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteShelterById(@PathVariable("id") int id) {
    this.shelterService.removeShelterById(id);
    // this.shelterRepo.delete(id);
  }
}
