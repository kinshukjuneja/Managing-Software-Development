package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.Pet;
import team.awesome.pet.repository.PetRepository;

/**
 * This is the Service layer for Pet which is used to implement all the methods that are created in
 * the Repository layer and also will be used to get information from the Controller layer.
 *
 */
@Service
public class PetService {

  @Autowired
  // @Qualifier("mockPetData")
  // private PetDao petDao;
  private PetRepository petRepository;

  /**
   * This method will use the provided function from JpaRepository which is findAll() to return all
   * the pets it can find.
   *
   * @return all pets that can be found
   */
  public Collection<Pet> getAllPets() {
    return this.petRepository.findAll();
  }

  /**
   * This method will use the provided function from JpaRepository which is findOne() to return the
   * specific pet with a matching id {@code id}.
   *
   * @param id the id of a pet that will be used to find it
   * @return the pet with a matching id
   */
  public Pet getPetById(int id) {
    return this.petRepository.findOne(id);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to update an
   * existing pet {@code pet} with an updated information.
   *
   * @param pet a pet that will be used to update its current information
   */
  public void updatePet(Pet pet) {
    this.petRepository.save(pet);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to create a new
   * pet {@code pet}.
   *
   * @param pet a pet that will be added to the Collection of pets
   */
  public void insertPet(Pet pet) {
    this.petRepository.save(pet);
  }

  /**
   * This method will use the provided function from JpaRepository which is delete() to delete an
   * existing pet with a matching id {@code id}.
   * 
   * @param id an id that will be used to find the pet that needs to be removed.
   */
  public void removePetById(int id) {
    this.petRepository.delete(id);
  }
}
