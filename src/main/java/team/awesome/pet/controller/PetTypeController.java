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

@RestController
@RequestMapping("/pet-types")
public class PetTypeController {

  @Autowired
  private PetTypeService petTypeService;
  // private TypeRepository typeRepo;

  @RequestMapping(method = RequestMethod.GET)
  public Collection<PetType> getAllPetType() {
    return this.petTypeService.getAllPetType();
    // return this.typeRepo.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public PetType getPetTypeById(@PathVariable("id") int id) {
    return this.petTypeService.getPetTypeById(id);
    // return this.typeRepo.findOne(id);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertShelter(@RequestBody PetType petType) {
    this.petTypeService.inserPetType(petType);
    // this.typeRepo.save(petType);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateShelter(@RequestBody PetType petType) {
    this.petTypeService.updatePetType(petType);
    // this.typeRepo.save(petType);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePetTypeById(@PathVariable("id") int id) {
    this.petTypeService.removePetType(id);
    // this.typeRepo.delete(id);
  }
}
