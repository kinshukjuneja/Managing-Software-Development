package team.awesome.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.model.Track;

public interface TrackRepository extends JpaRepository<Track, Integer>{

}
