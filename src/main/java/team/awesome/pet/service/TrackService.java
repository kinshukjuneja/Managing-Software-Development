package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.Track;
import team.awesome.pet.repository.TrackRepository;

@Service
public class TrackService {
	@Autowired
	private TrackRepository trackRepository;
	
	public Collection<Track> getAllTracks() {
		return this.trackRepository.findAll();
	}
	
	public Track getTrackById(int id) {
		return this.trackRepository.findOne(id);
	}
	
	public void insertTrack(Track track) {
		this.trackRepository.save(track);
	}
	
	public void updateTrack(Track track) {
		this.trackRepository.save(track);
	}
	
	public void removeTrack(int id) {
		this.trackRepository.delete(id);
	}
}
