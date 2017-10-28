package team.awesome.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.dao.PetDao;
import team.awesome.pet.model.Pet;

/**
 *
 * TODO: Implementing all the methods using Jpa repo. so that we can have better a service control
 * to interact with db and web services
 *
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {
	
}
