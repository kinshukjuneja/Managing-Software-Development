package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.entity.Shelter;
import team.awesome.pet.model.ShelterRepository;

@Service
public class ShelterService {
  @Autowired
  @Qualifier("mockShelterData")
  private ShelterRepository shelterRepo;

  public Collection<Shelter> getAllShelter() {
    return this.shelterRepo.getAllShelter();
  }

  public Shelter getShelterById(int id) {
    return this.shelterRepo.getShelterById(id);
  }

  public void addShelter(Shelter shelter) {
    this.shelterRepo.addShelterToDb(shelter);
  }

  public void updateShelter(Shelter shelter) {
    this.shelterRepo.updateShelter(shelter);
  }

  public void removeShelterById(int id) {
    this.shelterRepo.removeShelterById(id);
  }
}
