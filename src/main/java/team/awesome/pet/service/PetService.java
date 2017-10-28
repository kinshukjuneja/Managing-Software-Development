package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.dao.PetDao;
import team.awesome.pet.model.Pet;
import team.awesome.pet.repository.PetRepository;

@Service
public class PetService {
  // test comment

  @Autowired
//  @Qualifier("mockPetData")
//  private PetDao petDao;
  	private PetRepository petRepository;

  	public Collection<Pet> getAllPets() {
  		return this.petRepository.findAll();
  	}

  	public Pet getPetById(int id) {
  		return this.petRepository.findOne(id);
  	}

  	public void updatePet(Pet pet) {
  		this.petRepository.save(pet);
  	}

  	public void insertPet(Pet pet) {
  		this.petRepository.save(pet);
  	}

  	public void removePetById(int id) {
  		this.petRepository.delete(id);
  	}
}
