package team.awesome.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import team.awesome.pet.model.Track;
import team.awesome.pet.service.TrackService;
import java.math.BigInteger;
import java.util.Collection;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    private TrackService trackService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Track> getAllTracks() {
        return this.trackService.getAllTracks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Track getTrackById(@PathVariable("id") BigInteger id) {
        return this.trackService.getTrackById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTrack(@RequestBody Track track) {
        this.trackService.updateTrack(track);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTrack(@RequestBody Track track) {
        this.trackService.insertTrack(track);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrackById(@PathVariable("id") BigInteger id) {
        this.trackService.removeTrackById(id);
    }
}
