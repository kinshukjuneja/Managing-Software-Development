package team.awesome.pet.model;

import lombok.Builder;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents a track class to help find a pet
 *
 */
@Builder
@Entity
@Table(name = "Track")
public class Track {
  @Id
  @Column(name = "track_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int trackId;
  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
  @Column(name = "record_time")
  private Date recordTime;
  @Column(name = "record_location")
  private String recordLocation;

  /**
   * Create a track to record where a pet has been
   *
   * @param trackId the id of a track
   * @param pet the pet
   * @param recordTime record the time of a pet of places it has been to
   * @param recordLocation record the location of where pet has been to
   */
  public Track(int trackId, Pet pet, Date recordTime, String recordLocation) {
    super();
    this.trackId = trackId;
    this.pet = pet;
    this.recordTime = recordTime;
    this.recordLocation = recordLocation;
  }

  public Track() {}

  /**
   *
   * @return the id of a track
   */
  public int getTrackId() {
    return this.trackId;
  }

  /**
   *
   * @param trackId the id of a track to be set
   */
  public void setTrackId(int trackId) {
    this.trackId = trackId;
  }

  /**
   *
   * @return the pet
   */
  public Pet getPet() {
    return this.pet;
  }

  /**
   *
   * @param pet the pet to be set
   */
  public void setPet(Pet pet) {
    this.pet = pet;
  }

  /**
   *
   * @return the recording time of places a pet has been to
   */
  public Date getRecordTime() {
    return this.recordTime;
  }

  /**
   *
   * @param recordTime the record time to be set
   */
  public void setRecordTime(Date recordTime) {
    this.recordTime = recordTime;
  }

  /**
   *
   * @return the places where a pet has been to
   */
  public String getRecordLocation() {
    return this.recordLocation;
  }

  /**
   *
   * @param recordLocation the visited places of a pet to be set to
   */
  public void setRecordLocation(String recordLocation) {
    this.recordLocation = recordLocation;
  }

  @Override
  public String toString() {
    return "Track{" +
            "trackId=" + trackId + ", " +
            "pet=" + pet + ", " +
            "recordTime=" + recordTime + ", " +
            "recordLocation='" + recordLocation + '\'' +
            '}';
  }
}
