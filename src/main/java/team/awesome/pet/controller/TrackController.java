package team.awesome.pet.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.Pet;
import team.awesome.pet.model.Track;
import team.awesome.pet.service.TrackService;

/**
 * This represents the Controller layer for Track which will be used as a mean to communicate to the
 * Service layer to handle all the HTTP request
 *
 */
@RestController
@RequestMapping("/tracks")
public class TrackController {

  @Autowired
  private TrackService trackService;
  // private TrackRepository trackRepo;

  /**
   * HTTP GET method will return all the tracks in the existing Collection
   *
   * @return all the tracks it can find
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<Track> getAllTracks() {
    return this.trackService.getAllTracks();
    // return this.trackRepo.findAll();
  }
  
  @RequestMapping(value = "/pets", method = RequestMethod.GET)
  public Collection<Track> findTrackByPet(
		  @RequestParam(value = "petId", required = false) int petId) {
	  return this.trackService.findTrackByPet(petId);
  }

  /**
   * HTTP GET method will return the specific track given the id
   *
   * @param id the integer id that will be used to find a track
   * @return the track with a matching id
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Track getTrackById(@PathVariable("id") int id) {
    return this.trackService.getTrackById(id);
    // return this.trackRepo.findOne(id);
  }

  /**
   * HTTP PUT method will help to update the existing track with new information
   *
   * @param track a track that needs to be updated
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateTrack(@RequestBody Track track) {
    this.trackService.updateTrack(track);
    // this.trackRepo.save(track);

  }

  /**
   * HTTP POST method will help to add a new track to the existing one
   *
   * @param track a new track that needs to be added
   */
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertTrack(@RequestBody Track track) {
    this.trackService.insertTrack(track);
    // this.trackRepo.save(track);
  }

  /**
   * HTTP DELETE method will help to delete an existing track given the id
   *
   * @param id an id of the track that will be removed from the record
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteTrackById(@PathVariable("id") int id) {
    this.trackService.removeTrack(id);
    // this.trackRepo.delete(id);
  }

}
