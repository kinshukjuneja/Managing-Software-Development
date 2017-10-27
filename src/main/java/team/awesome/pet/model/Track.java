package team.awesome.pet.model;

import java.math.BigInteger;

public class Track {
    private BigInteger trackId;
    private int petId;
    private long time;
    private String location;

    public Track(BigInteger trackId, int petId, long time, String location) {
        this.trackId = trackId;
        this.petId = petId;
        this.time = System.currentTimeMillis();
        this.location = location;
    }

    public Track() {}

    /**
     * @return the trackId
     */
    public BigInteger getTrackId() {
        return trackId;
    }

    /**
     * @param trackId the trackId to set
     */
    public void setTrackId(BigInteger trackId) {
        this.trackId = trackId;
    }

    /**
     * @return the petId of a pet
     */
    public int getPetId() {
        return petId;
    }

    /**
     * @param petId the petId to set
     */
    public void setPetId(int petId) {
        this.petId = petId;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @return the location of a pet
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set as a String in Coordinates(Latitude and Longitude)
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
