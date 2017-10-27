package team.awesome.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import team.awesome.pet.dao.TrackDao;
import team.awesome.pet.model.Track;
import java.math.BigInteger;
import java.util.Collection;

public class TrackService {

    @Autowired
    @Qualifier("mockTrackData")
    private TrackDao trackDao;

    public Collection<Track> getAllTracks() {
        return this.trackDao.getAllTracks();
    }

    public Track getTrackById(BigInteger id) {
        return this.trackDao.getTrackById(id);
    }

    public void updateTrack(Track track) {
        this.trackDao.updateTrack(track);
    }

    public void insertTrack(Track track) {
        this.trackDao.insertTrackToDb(track);
    }

    public void removeTrackById(BigInteger id) {
        this.trackDao.removeTrackById(id);
    }
}

