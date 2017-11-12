package team.awesome.pet.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.Track;
import team.awesome.pet.repository.TrackRepository;

/**
 * This is the Service layer for Track which is used to implement all the methods that are created
 * in the Repository layer and also will be used to get information from the Controller layer.
 *
 */
@Service
public class TrackService {
  @Autowired
  private TrackRepository trackRepository;

  /**
   * This method will use the provided function from JpaRepository which is findAll() to return all
   * the tracks it can find.
   *
   * @return all tracks that can be found
   */
  public Collection<Track> getAllTracks() {
    return this.trackRepository.findAll();
  }

  /**
   * This method will use the provided function from JpaRepository which is findOne() to return the
   * specific track with a matching id {@code id}.
   *
   * @param id the integer id that will be used to find a track
   * @return the track with a matching id
   */
  public Track getTrackById(int id) {
    return this.trackRepository.findOne(id);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to create a new
   * track {@code track}.
   *
   * @param track that will be added to the Collection of track
   */
  public void insertTrack(Track track) {
    this.trackRepository.save(track);
  }

  /**
   * This method will use the provided function from JpaRepository which is save() to update an
   * existing track {@code track} with an updated information.
   *
   * @param track that will be used to update its current information
   */
  public void updateTrack(Track track) {
    this.trackRepository.save(track);
  }

  /**
   * This method will use the provided function from JpaRepository which is delete() to delete an
   * existing track with a matching id {@code id}.
   *
   * @param id that will be used to find the track that needs to be removed.
   */
  public void removeTrack(int id) {
    this.trackRepository.delete(id);
  }

  /**
   * This method will use the existing method created in the TrackRepository to find the list of
   * tracks given a petId of where a pet has
   *
   * @param petId the petId that will be used to find the list of tracks
   * @return list of tracks with the matching petId {@code petId} of where a pet has been
   */
  public List<Track> findTrackByPet(int petId) {
    return this.trackRepository.findByPet_PetId(petId);
  }

}
