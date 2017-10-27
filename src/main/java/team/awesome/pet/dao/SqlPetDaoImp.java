package team.awesome.pet.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.model.Pet;

@Repository
@Qualifier("sqlData")
public class SqlPetDaoImp implements PetDao {

  @Override
  public Collection<Pet> getAllPets() {
    return new ArrayList<Pet>() {
      {
        add(new Pet(1, "Snowy", new BigInteger("1234567890")));
      }
    };
  }

  @Override
  public Pet getPetById(int id) {
    return null;
  }

  @Override
  public void updatePet(Pet pet) {

  }

  @Override
  public void insertPetToDb(Pet pet) {

  }

  @Override
  public void removePetById(int id) {

  }
}
