package team.awesome.pet.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.model.Pet;

@Repository
@Qualifier("mockPetData")
public class MockPetDaoImp implements PetDao {
  private static Map<Integer, Pet> pets;
  static {
    MockPetDaoImp.pets = new HashMap<Integer, Pet>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      {
        // put(1, new Pet(1, "Mimi", new BigInteger("1234567890")));
        // put(2, new Pet(2, "Max", new BigInteger("1234567891")));
        // put(3, new Pet(3, "Lilac", new BigInteger("1234567892")));
      }
    };
  }

  @Override
  public Collection<Pet> getAllPets() {
    return MockPetDaoImp.pets.values();
  }

  @Override
  public Pet getPetById(int id) {
    return MockPetDaoImp.pets.get(id);
  }

  @Override
  public void updatePet(Pet pet) {
    // Pet p = MockPetDaoImp.pets.get(pet.getPetId());
    // p.setName(pet.getName());
    // p.setShelterId(pet.getShelterId());
    MockPetDaoImp.pets.put(pet.getPetId(), pet);
  }

  @Override
  public void insertPetToDb(Pet pet) {
    MockPetDaoImp.pets.put(pet.getPetId(), pet);
  }

  @Override
  public void removePetById(int id) {
    MockPetDaoImp.pets.remove(id);
  }
}
