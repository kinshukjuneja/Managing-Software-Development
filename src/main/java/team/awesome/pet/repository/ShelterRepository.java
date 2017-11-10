package team.awesome.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.model.Shelter;

public interface ShelterRepository extends JpaRepository<Shelter, Integer> {

}
