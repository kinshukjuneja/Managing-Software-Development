package team.awesome.pet.model;

import java.util.Collection;

import team.awesome.pet.entity.Shelter;

public interface ShelterRepository {

  Collection<Shelter> getAllShelter();

  Shelter getShelterById(int id);

  void addShelterToDb(Shelter shelter);

  void updateShelter(Shelter shelter);

  void removeShelterById(int id);
}
