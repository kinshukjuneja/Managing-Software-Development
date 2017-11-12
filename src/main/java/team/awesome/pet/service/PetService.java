package team.awesome.pet.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.Pet;
import team.awesome.pet.model.PetType;
import team.awesome.pet.model.Shelter;
import team.awesome.pet.model.User;
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

  /**
   * This extra method will help to search for pet using its given features
   *
   * @param name the name of the pet
   * @param ownerId the id of the pet's owner
   * @param typeId the id of the pet's type
   * @param shelterId the id of the shelter
   * @param length the length of the pet
   * @param weight the weight of the pet
   * @param color the color of the pet
   * @param health the health status of the pet
   * @param location the location of where a pet is currently
   * @return pets with matching given features
   */
  @SuppressWarnings("unchecked")
  public Collection<Pet> findPetsByFeatures(String name, String ownerId, String typeId,
      String shelterId, String length, String weight, String color, String health,
      String location) {

    @SuppressWarnings("unused")
    List<Pet> result = null;
    Specification querySpecific = new Specification<Pet>() {

      @Override
      public Predicate toPredicate(Root<Pet> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        if (name != null) {
          predicates.add(cb.equal(root.get("name"), name));
        }
        if (ownerId != null) {
          Join<Pet, User> petJoinUser = root.join("owner", JoinType.LEFT);
          predicates.add(cb.equal(petJoinUser.get("userID"), Integer.parseInt(ownerId)));
        }
        if (typeId != null) {
          Join<Pet, PetType> petJoinType = root.join("petType", JoinType.LEFT);
          predicates.add(cb.equal(petJoinType.get("typeId"), Integer.parseInt(typeId)));
        }
        if (shelterId != null) {
          Join<Pet, Shelter> petJoinShelter = root.join("shelter", JoinType.LEFT);
          predicates.add(cb.equal(petJoinShelter.get("shelterId"), Integer.parseInt(shelterId)));
        }
        if (length != null) {
          predicates.add(cb.equal(root.get("petLength"), Double.parseDouble(length)));
        }
        if (weight != null) {
          predicates.add(cb.equal(root.get("petWeight"), Double.parseDouble(weight)));
        }
        if (color != null) {
          predicates.add(cb.equal(root.get("petColor"), color));
        }
        if (health != null) {
          predicates.add(cb.equal(root.get("healthStatus"), health));
        }
        if (location != null) {
          predicates.add(cb.equal(root.get("currentLocation"), location));
        }

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
      }
    };
    return this.petRepository.findAll(querySpecific);
  }
}
