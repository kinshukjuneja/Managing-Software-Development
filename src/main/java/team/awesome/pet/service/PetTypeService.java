package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.dao.PetTypeDao;
import team.awesome.pet.model.PetType;

@Service
public class PetTypeService {

  @Autowired
  @Qualifier("mockPetTypeData")
  private PetTypeDao petTypeDao;

  public Collection<PetType> getAllPetType() {
    return this.petTypeDao.getAllPetType();
  }

  public PetType getPetTypeById(int id) {
    return this.petTypeDao.getPetTypeById(id);
  }

  public void updatePetType(PetType petType) {
    this.petTypeDao.updatePetType(petType);
  }

  public void removePetType(int id) {
    this.petTypeDao.removePetType(id);
  }

}
