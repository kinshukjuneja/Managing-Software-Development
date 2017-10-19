package team.awesome.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.dao.jpa.PetsRepository;
import team.awesome.pet.model.Pet;

@RestController
@RequestMapping("/rest/pets")
public class PetsController {

	@Autowired
	PetsRepository petsRepository;
	
	@GetMapping("/all")
	public List<Pet> getAll() {
		return petsRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Pet getPetById(@PathVariable("id") final Integer id) {
		return petsRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updatePet(@RequestBody Pet pet) {
		petsRepository.save(pet);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertPet(@RequestBody Pet pet) {
		petsRepository.save(pet);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePetById(@PathVariable("id") int id) {
	    petsRepository.delete(id);
	}
}
