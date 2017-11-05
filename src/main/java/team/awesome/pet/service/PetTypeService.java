package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.PetType;
import team.awesome.pet.repository.TypeRepository;

/**
 * This is the Service layer for PetType which is used to implement all the methods that are created
 * in the Repository layer and also will be used to get information from the Controller layer.
 *
 */
@Service
public class PetTypeService {

  @Autowired
  // @Qualifier("mockPetTypeData")
  // private PetTypeDao petTypeDao;
  private TypeRepository typeRepository;

  /**
   * This method will use the provided function from JpaRepository which is findAll() to return all
   * the pet types it can find.
   *
   * @return all pet types that can be found
   */
  public Collection<PetType> getAllPetType() {
    return this.typeRepository.findAll();
  }

  /**
   * This method will use the provided function from JpaRepository which is findOne() to return the
   * specific pet type with a matching id {@code id}.
   *
   * @param id the id of a pet type that will be used to find it
   * @return the pet type with a matching id
   */
  public PetType getPetTypeById(int id) {
    return this.typeRepository.findOne(id);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to create a new
   * pet type {@code petType}.
   *
   * @param petType a petType that will be added to the Collection of pet type
   */
  public void inserPetType(PetType petType) {
    this.typeRepository.save(petType);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to update an
   * existing pet type {@code petType} with an updated information.
   *
   * @param petType a petType that will be used to update its current information
   */
  public void updatePetType(PetType petType) {
    this.typeRepository.save(petType);
  }

  /**
   * This method will use the provided function from JpaRepository which is delete() to delete an
   * existing pet type with a matching id {@code id}.
   *
   * @param id an id that will be used to find the pet type that needs to be removed.
   */
  public void removePetType(int id) {
    this.typeRepository.delete(id);
  }

}
