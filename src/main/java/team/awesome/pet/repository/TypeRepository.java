package team.awesome.pet.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.dao.PetTypeDao;
import team.awesome.pet.model.PetType;

/**
 *
 * TODO: Implementing all the methods using Jpa repo. so that we can have better a service control
 * to interact with db and web services
 *
 */
public interface TypeRepository extends JpaRepository<PetType, Integer> {

}
