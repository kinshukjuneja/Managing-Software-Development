package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.Shelter;
import team.awesome.pet.repository.ShelterRepository;

/**
 * This is the Service layer for Shelter which is used to implement all the methods that are created
 * in the Repository layer and also will be used to get information from the Controller layer.
 *
 */
@Service
public class ShelterService {
  @Autowired
  // @Qualifier("mockShelterData")
  // private ShelterDao shelterDao;
  private ShelterRepository shelterRepository;

  /**
   * This method will use the provided function from JpaRepository which is findAll() to return all
   * the shelters it can find.
   *
   * @return all shelters that can be found
   */
  public Collection<Shelter> getAllShelter() {
    return this.shelterRepository.findAll();
  }

  /**
   * This method will use the provided function from JpaRepository which is findOne() to return the
   * specific shelter with a matching id {@code id}.
   *
   * @param id the integer id that will be used to find a shelter
   * @return the shelter with a matching id
   */
  public Shelter getShelterById(int id) {
    return this.shelterRepository.findOne(id);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to create a new
   * shelter {@code shelter}.
   *
   * @param shelter that will be added to the Collection of shelter
   */
  public void insertShelter(Shelter shelter) {
    this.shelterRepository.save(shelter);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to update an
   * existing shelter {@code shelter} with an updated information.
   *
   * @param shelter that will be used to update its current information
   */
  public void updateShelter(Shelter shelter) {
    this.shelterRepository.save(shelter);
  }

  /**
   * This method will use the provided function from JpaRepository which is delete() to delete an
   * existing shelter with a matching id {@code id}.
   *
   * @param id that will be used to find the shelter that needs to be removed.
   */
  public void removeShelterById(int id) {
    this.shelterRepository.delete(id);
  }
}
