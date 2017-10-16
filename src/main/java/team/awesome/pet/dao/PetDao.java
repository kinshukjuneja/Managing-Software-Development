package team.awesome.pet.dao;

import java.util.Collection;

import team.awesome.pet.entity.Pet;

public interface PetDao {
  Collection<Pet> getAllPets();

  Pet getPetById(int id);

  void updatePet(Pet pet);

  void insertPetToDb(Pet pet);

  void removePetById(int id);
}
