package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.dao.PetDao;
import team.awesome.pet.model.Pet;

@Service
public class PetService {
  // test comment

  @Autowired
  @Qualifier("mockPetData")
  private PetDao petDao;

  public Collection<Pet> getAllPets() {
    return this.petDao.getAllPets();
  }

  public Pet getPetById(int id) {
    return this.petDao.getPetById(id);
  }

  public void updatePet(Pet pet) {
    this.petDao.updatePet(pet);
  }

  public void insertPet(Pet pet) {
    this.petDao.insertPetToDb(pet);
  }

  public void removePetById(int id) {
    this.petDao.removePetById(id);
  }
}
