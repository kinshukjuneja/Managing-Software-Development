package team.awesome.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.Pet;
import team.awesome.pet.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

  @Autowired
  // private PetService petService;
  private PetRepository petRepo;

  @RequestMapping(method = RequestMethod.GET)
  public List<Pet> getAllPets() {
    // return this.petService.getAllPets();
    return this.petRepo.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Pet getPetById(@PathVariable("id") int id) {
    // return this.petService.getPetById(id);
    return this.petRepo.findOne(id);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updatePet(@RequestBody Pet pet) {
    // this.petService.updatePet(pet);
    this.petRepo.save(pet);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertPet(@RequestBody Pet pet) {
    // this.petService.insertPet(pet);
    this.petRepo.save(pet);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePetById(@PathVariable("id") int id) {
    // this.petService.removePetById(id);
    this.petRepo.delete(id);
  }
}
