package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.entity.Pet;
import team.awesome.pet.dao.PetDao;

@Service
public class PetService {
  //test comment

  @Autowired
  @Qualifier("mockData")
  private PetDao petDb;

  public Collection<Pet> getAllPets() {
    return this.petDb.getAllPets();
  }

  public Pet getPetById(int id) {
    return this.petDb.getPetById(id);
  }

  public void updatePet(Pet pet) {
    this.petDb.updatePet(pet);
  }

  public void insertPet(Pet pet) {
    this.petDb.insertPetToDb(pet);
  }

  public void removePetById(int id) {
    this.petDb.removePetById(id);
  }
}
