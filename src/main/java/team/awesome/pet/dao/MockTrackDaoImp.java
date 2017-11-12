package team.awesome.pet.dao;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.model.Track;

@Repository
@Qualifier("mockTrackData")
public class MockTrackDaoImp implements TrackDao {
  private static Map<BigInteger, Track> tracks;
  static {
    MockTrackDaoImp.tracks = new HashMap<BigInteger, Track>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      // {
      // put(new BigInteger("1"), new Track(new BigInteger("1"), 2, System.currentTimeMillis(),
      // "Seattle"));
      // put(new BigInteger("2"), new Track(new BigInteger("3"), 4, System.currentTimeMillis(),
      // "Tacoma"));
      // put(new BigInteger("3"), new Track(new BigInteger("5"), 6, System.currentTimeMillis(),
      // "Redmond"));
      // }
    };
  }

  @Override
  public Collection<Track> getAllTracks() {
    return MockTrackDaoImp.tracks.values();
  }

  @Override
  public Track getTrackById(BigInteger id) {
    return MockTrackDaoImp.tracks.get(id);
  }

  @Override
  public void updateTrack(Track track) {
    // Track t = MockTrackDaoImp.tracks.get(track.getTrackId());
    // t.setPetId(track.getPetId());
    // t.setTime(track.getTime());
    // t.setLocation(track.getLocation());
    // MockTrackDaoImp.tracks.put(track.getTrackId(), track);
  }

  @Override
  public void insertTrackToDb(Track track) {
    // MockTrackDaoImp.tracks.put(track.getTrackId(), track);
  }

  @Override
  public void removeTrackById(BigInteger id) {
    MockTrackDaoImp.tracks.remove(id);
  }
}
