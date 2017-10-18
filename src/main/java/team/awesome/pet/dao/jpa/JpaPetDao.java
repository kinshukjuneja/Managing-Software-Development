package team.awesome.pet.dao.jpa;

import java.util.Collection;

import team.awesome.pet.dao.PetDao;
import team.awesome.pet.model.Pet;

/**
 *
 * TODO: Implementing all the methods using Jpa repo. so that we can have better a service control
 * to interact with db and web services
 *
 */
public class JpaPetDao implements PetDao {

  @Override
  public Collection<Pet> getAllPets() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Pet getPetById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updatePet(Pet pet) {
    // TODO Auto-generated method stub

  }

  @Override
  public void insertPetToDb(Pet pet) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePetById(int id) {
    // TODO Auto-generated method stub

  }

}
