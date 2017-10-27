package team.awesome.pet.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

  @RequestMapping(method = RequestMethod.GET)
  public Collection<PetType> getAllPetType() {
    return this.petTypeService.getAllPetType();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public PetType getPetTypeById(int id) {
    return this.petTypeService.getPetTypeById(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PetType> updatePetType(@PathVariable("id") int id,
      @RequestBody @Valid PetType petType) {
    PetType type = this.petTypeService.getPetTypeById(id);
    if (type == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    type.setName(petType.getName());
    this.petTypeService.updatePetType(type);
    return new ResponseEntity<>(type, HttpStatus.NO_CONTENT);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePetTypeById(int id) {
    this.petTypeService.removePetType(id);
  }

}
