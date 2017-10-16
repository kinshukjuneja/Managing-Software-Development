package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.awesome.pet.entity.Shelter;
import team.awesome.pet.dao.ShelterDao;

@Service
public class ShelterService {
  @Autowired
  @Qualifier("mockShelterDaoImp")
  private ShelterDao shelterDao;

  public Collection<Shelter> getAllShelter() {
    return this.shelterDao.getAllShelters();
  }

  public Shelter getShelterById(int id) {
    return this.shelterDao.getShelterById(id);
  }

  public void insertShelter(Shelter shelter) {
    this.shelterDao.insertShelterToDb(shelter);
  }

  public void updateShelter(Shelter shelter) {
    this.shelterDao.updateShelter(shelter);
  }

  public void removeShelterById(int id) {
    this.shelterDao.removeShelterById(id);
  }
}
