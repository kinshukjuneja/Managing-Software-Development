package team.awesome.pet.model;

import java.util.Collection;

import team.awesome.pet.entity.Pet;

public interface PetDb {
  Collection<Pet> getAllPets();

  Pet getPetById(int id);

  void updatePet(Pet pet);

  void insertPetToDb(Pet pet);

  void removePetById(int id);
}
