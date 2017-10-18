package team.awesome.pet.dao.jpa;

import java.util.Collection;

import team.awesome.pet.dao.PetTypeDao;
import team.awesome.pet.model.PetType;

/**
 *
 * TODO: Implementing all the methods using Jpa repo. so that we can have better a service control
 * to interact with db and web services
 *
 */
public class JpaPetTypeDao implements PetTypeDao {

  @Override
  public Collection<PetType> getAllPetType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PetType getPetTypeById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updatePetType(PetType petType) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePetType(int id) {
    // TODO Auto-generated method stub

  }

}
