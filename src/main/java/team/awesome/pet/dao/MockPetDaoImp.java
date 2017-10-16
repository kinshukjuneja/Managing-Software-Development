package team.awesome.pet.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.entity.Pet;

@Repository
@Qualifier("mockData")
public class MockPetDaoImp implements PetDao {
  private static Map<Integer, Pet> pets;
  static {
    MockPetDaoImp.pets = new HashMap<Integer, Pet>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      {
        put(1, new Pet(1, "Mimi", "Seattle-Shelter"));
        put(2, new Pet(2, "Max", "Bellevue-Shelter"));
        put(3, new Pet(3, "Lilac", "Tacoma-Shelter"));
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
    Pet p = MockPetDaoImp.pets.get(pet.getId());
    p.setName(pet.getName());
    p.setShelter(pet.getShelter());
    MockPetDaoImp.pets.put(pet.getId(), pet);
  }

  @Override
  public void insertPetToDb(Pet pet) {
    MockPetDaoImp.pets.put(pet.getId(), pet);
  }

  @Override
  public void removePetById(int id) {
    MockPetDaoImp.pets.remove(id);
  }
}
