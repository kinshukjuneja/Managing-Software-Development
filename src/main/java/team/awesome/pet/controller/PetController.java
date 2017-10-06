package team.awesome.pet.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.entity.Pet;
import team.awesome.pet.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

  @Autowired
  private PetService petService;

  @RequestMapping(method = RequestMethod.GET)
  public Collection<Pet> getAllPets() {
    return this.petService.getAllPets();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Pet getPetById(@PathVariable("id") int id) {
    return this.petService.getPetById(id);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void deletePetById(@RequestBody Pet pet) {
    this.petService.updatePet(pet);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertPet(@RequestBody Pet pet) {
    this.petService.insertPet(pet);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePetById(@PathVariable("id") int id) {
    this.petService.removePetById(id);
  }
}