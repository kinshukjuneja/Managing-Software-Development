package team.awesome.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
