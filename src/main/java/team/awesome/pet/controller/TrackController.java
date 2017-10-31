package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.Track;
import team.awesome.pet.service.TrackService;

@RestController
@RequestMapping("/track")
public class TrackController {

  @Autowired
  private TrackService trackService;
  // private TrackRepository trackRepo;

  @RequestMapping(method = RequestMethod.GET)
  public Collection<Track> getAllTracks() {
    return this.trackService.getAllTracks();
    // return this.trackRepo.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Track getTrackById(@PathVariable("id") int id) {
    return this.trackService.getTrackById(id);
    // return this.trackRepo.findOne(id);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateTrack(@RequestBody Track track) {
    this.trackService.updateTrack(track);
    // this.trackRepo.save(track);

  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertTrack(@RequestBody Track track) {
    this.trackService.insertTrack(track);
    // this.trackRepo.save(track);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteTrackById(@PathVariable("id") int id) {
    this.trackService.removeTrack(id);
    // this.trackRepo.delete(id);
  }
}
