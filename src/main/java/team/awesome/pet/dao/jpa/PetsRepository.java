package team.awesome.pet.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.model.Pet;

public interface PetsRepository extends JpaRepository<Pet, Integer>{
	List<Pet> findByName(String name);
}
