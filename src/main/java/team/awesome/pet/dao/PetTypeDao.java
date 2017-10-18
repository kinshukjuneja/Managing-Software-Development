package team.awesome.pet.dao;

import java.util.Collection;

import team.awesome.pet.model.PetType;

public interface PetTypeDao {

  Collection<PetType> getAllPetType();

  PetType getPetTypeById(int id);

  void updatePetType(PetType petType);

  void removePetType(int id);

}
