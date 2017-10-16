package team.awesome.pet.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.entity.Pet;

@Repository
@Qualifier("mockData")
public class MockPetData implements PetDao {
  private static Map<Integer, Pet> pets;
  static {
    MockPetData.pets = new HashMap<Integer, Pet>() {

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
    return MockPetData.pets.values();
  }

  @Override
  public Pet getPetById(int id) {
    return MockPetData.pets.get(id);
  }

  @Override
  public void updatePet(Pet pet) {
    Pet p = MockPetData.pets.get(pet.getId());
    p.setName(pet.getName());
    p.setShelter(pet.getShelter());
    MockPetData.pets.put(pet.getId(), pet);
  }

  @Override
  public void insertPetToDb(Pet pet) {
    MockPetData.pets.put(pet.getId(), pet);
  }

  @Override
  public void removePetById(int id) {
    MockPetData.pets.remove(id);
  }
}
