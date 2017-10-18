package team.awesome.pet.dao.jpa;

import java.util.Collection;

import team.awesome.pet.dao.ShelterDao;
import team.awesome.pet.model.Shelter;

/**
 *
 * TODO: Implementing all the methods using Jpa repo. so that we can have better a service control
 * to interact with db and web services
 *
 */

public class JpaShelterDao implements ShelterDao {

  @Override
  public Collection<Shelter> getAllShelters() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Shelter getShelterById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateShelter(Shelter shelter) {
    // TODO Auto-generated method stub

  }

  @Override
  public void insertShelterToDb(Shelter shelter) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeShelterById(int id) {
    // TODO Auto-generated method stub

  }

}
