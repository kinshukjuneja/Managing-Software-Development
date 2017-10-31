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
import team.awesome.pet.service.ShelterService;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

  @Autowired
  // private ShelterRepository shelterRepo;
  private ShelterService shelterService;

  @RequestMapping(method = RequestMethod.GET)
  public Collection<Shelter> getAllShelter() {
    return this.shelterService.getAllShelter();
    // return this.shelterRepo.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Shelter getShelterById(@PathVariable("id") int id) {
    return this.shelterService.getShelterById(id);
    // return this.shelterRepo.findOne(id);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertShelter(@RequestBody Shelter shelter) {
    this.shelterService.insertShelter(shelter);
    // this.shelterRepo.save(shelter);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateShelter(@RequestBody Shelter shelter) {
    this.shelterService.updateShelter(shelter);
    // this.shelterRepo.save(shelter);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteShelterById(@PathVariable("id") int id) {
    this.shelterService.removeShelterById(id);
    // this.shelterRepo.delete(id);
  }
}
