package team.awesome.pet.dao;

import java.math.BigInteger;
import java.util.Collection;

import team.awesome.pet.model.Pet;
import team.awesome.pet.model.PetType;
import team.awesome.pet.model.Shelter;
import team.awesome.pet.model.User;

/**
 *
 * This helps to create one single control point and keep track of all the Data access object (DAO)
 * for this project
 *
 * @author Chuong Tran
 *
 */

public interface PetRescueOrganizationDao {

  /**
   * All Pet's Restful API calls
   */

  Collection<Pet> getAllPets();

  Pet getPetById(int id);

  void updatePet(Pet pet);

  void insertPetToDb(Pet pet);

  void removePetById(int id);

  /**
   * All Pet Type's related Restful API calls.
   */

  Collection<PetType> getAllPetType();

  PetType getPetTypeById(int id);

  void updatePetType(PetType petType);

  void removePetType(int id);

  /**
   * All Shelter's related Restful API calls.
   */

  Collection<Shelter> getAllShelter();

  Shelter getShelterById(int id);

  void addShelterToDb(Shelter shelter);

  void updateShelter(Shelter shelter);

  void removeShelterById(BigInteger id);

  /**
   * All User's related Restful API calls.
   */


  Collection<User> getAllUsers();

  User getUserById(int id);

  void updateUser(User user);

  void insertUserToDb(User user);

  void removeUserById(int id);

}


