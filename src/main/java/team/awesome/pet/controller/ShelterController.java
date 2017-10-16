package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.entity.Shelter;
import team.awesome.pet.service.ShelterService;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

  @Autowired
  private ShelterService shelterService;

  @RequestMapping(method = RequestMethod.GET)
  public Collection<Shelter> getAllShelter() {
    return this.shelterService.getAllShelter();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Shelter getShelterById(@PathVariable("id") int id) {
    return this.shelterService.getShelterById(id);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertShelter(@RequestBody Shelter shelter) {
    this.shelterService.insertShelter(shelter);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateShelter(@RequestBody Shelter shelter) {
    this.shelterService.updateShelter(shelter);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteShelterById(@PathVariable("id") int id) {
    this.shelterService.removeShelterById(id);
  }
}
