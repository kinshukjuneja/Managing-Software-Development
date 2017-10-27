package team.awesome.pet.dao;

import team.awesome.pet.model.Track;
import java.math.BigInteger;
import java.util.Collection;

public interface TrackDao {
    Collection<Track> getAllTracks();

    Track getTrackById(BigInteger id);

    void updateTrack(Track track);

    void insertTrackToDb(Track track);

    void removeTrackById(BigInteger id);
}
