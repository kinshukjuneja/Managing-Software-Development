package team.awesome.pet.dao;

import java.util.Collection;

import team.awesome.pet.entity.Shelter;

public interface ShelterDao {
  Collection<Shelter> getAllShelters();

  Shelter getShelterById(int id);

  void updateShelter(Shelter shelter);

  void insertShelterToDb(Shelter shelter);

  void removeShelterById(int id);
}
