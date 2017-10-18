package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import team.awesome.pet.dao.PetDao;
import team.awesome.pet.dao.PetRescueOrganizationDao;
import team.awesome.pet.dao.PetTypeDao;
import team.awesome.pet.dao.ShelterDao;
import team.awesome.pet.dao.UserDao;
import team.awesome.pet.model.Pet;
import team.awesome.pet.model.PetType;
import team.awesome.pet.model.Shelter;
import team.awesome.pet.model.User;

public class PetRescueOrganizationService implements PetRescueOrganizationDao {

  private PetDao petDao;
  private PetTypeDao petTypeDao;
  private ShelterDao shelterDao;
  private UserDao userDao;

  @Autowired
  public PetRescueOrganizationService(PetDao petDao, PetTypeDao petTypeDao, ShelterDao shelterDao,
      UserDao userDao) {
    super();
    this.petDao = petDao;
    this.petTypeDao = petTypeDao;
    this.shelterDao = shelterDao;
    this.userDao = userDao;
  }

  // Add @Transactional to hook up with DB

  @Override
  public Collection<Pet> getAllPets() {
    return this.petDao.getAllPets();
  }

  @Override
  public Pet getPetById(int id) {
    return this.petDao.getPetById(id);
  }

  @Override
  public void updatePet(Pet pet) {
    this.petDao.updatePet(pet);
  }

  @Override
  public void insertPetToDb(Pet pet) {
    this.petDao.insertPetToDb(pet);
  }

  @Override
  public void removePetById(int id) {
    this.petDao.removePetById(id);

  }

  @Override
  public Collection<PetType> getAllPetType() {
    return this.petTypeDao.getAllPetType();
  }

  @Override
  public PetType getPetTypeById(int id) {
    return this.petTypeDao.getPetTypeById(id);
  }

  @Override
  public void updatePetType(PetType petType) {
    this.petTypeDao.updatePetType(petType);
  }

  @Override
  public void removePetType(int id) {
    this.petTypeDao.removePetType(id);
  }

  @Override
  public Collection<Shelter> getAllShelter() {
    return this.shelterDao.getAllShelters();
  }

  @Override
  public Shelter getShelterById(int id) {
    return this.shelterDao.getShelterById(id);
  }

  @Override
  public void addShelterToDb(Shelter shelter) {
    this.shelterDao.insertShelterToDb(shelter);
  }

  @Override
  public void updateShelter(Shelter shelter) {
    this.shelterDao.updateShelter(shelter);
  }

  @Override
  public void removeShelterById(int id) {
    this.shelterDao.removeShelterById(id);
  }

  @Override
  public Collection<User> getAllUsers() {
    return this.userDao.getAllUsers();
  }

  @Override
  public User getUserById(int id) {
    return this.userDao.getUserById(id);
  }

  @Override
  public void updateUser(User user) {
    this.userDao.updateUser(user);

  }

  @Override
  public void insertUserToDb(User user) {
    this.userDao.insertUserToDb(user);
  }

  @Override
  public void removeUserById(int id) {
    this.userDao.removeUserById(id);

  }

}
