package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.Pet;
import team.awesome.pet.model.Track;
import team.awesome.pet.service.TrackService;

@RestController
@RequestMapping("/track")
public class TrackController {
	
	@Autowired
	private TrackService trackService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Track> getAllPets() {
		return this.trackService.getAllTracks();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Track getPetById(@PathVariable("id") int id) {
		return this.trackService.getTrackById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updatePet(@RequestBody Track track) {
		this.trackService.updateTrack(track);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertPet(@RequestBody Track track) {
		this.trackService.insertTrack(track);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePetById(@PathVariable("id") int id) {
		this.trackService.removeTrack(id);
	}
}
