package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.dao.PetTypeDao;
import team.awesome.pet.model.PetType;
import team.awesome.pet.repository.TypeRepository;

@Service
public class PetTypeService {

  @Autowired
//  @Qualifier("mockPetTypeData")
//  private PetTypeDao petTypeDao;
  	private TypeRepository typeRepository;

  	public Collection<PetType> getAllPetType() {
  		return this.typeRepository.findAll();
  	}

  	public PetType getPetTypeById(int id) {
  		return this.typeRepository.findOne(id);
  	}
  
  	public void inserPetType(PetType petType) {
  		this.typeRepository.save(petType);
  	}

  	public void updatePetType(PetType petType) {
  		this.typeRepository.save(petType);
  	}

  	public void removePetType(int id) {
  		this.typeRepository.delete(id);
  	}

}
