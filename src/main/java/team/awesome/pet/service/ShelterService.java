package team.awesome.pet.service;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.dao.ShelterDao;
import team.awesome.pet.model.Shelter;
import team.awesome.pet.repository.ShelterRepository;

@Service
public class ShelterService {
  @Autowired
//  @Qualifier("mockShelterData")
//  private ShelterDao shelterDao;
  	private ShelterRepository shelterRepository;

  	public Collection<Shelter> getAllShelter() {
  		return this.shelterRepository.findAll();
  	}

  	public Shelter getShelterById(int id) {
  		return this.shelterRepository.findOne(id);
  	}

  	public void insertShelter(Shelter shelter) {
  		this.shelterRepository.save(shelter);
  	}

  	public void updateShelter(Shelter shelter) {
  		this.shelterRepository.save(shelter);
  	}

  	public void removeShelterById(int id) {
  		this.shelterRepository.delete(id);
  	}
}
