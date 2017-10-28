package team.awesome.pet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	public Track(int trackId, Pet pet, Date recordTime, String recordLocation) {
		super();
		this.trackId = trackId;
		this.pet = pet;
		this.recordTime = recordTime;
		this.recordLocation = recordLocation;
	}

	public Track() {}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getRecordLocation() {
		return recordLocation;
	}

	public void setRecordLocation(String recordLocation) {
		this.recordLocation = recordLocation;
	}
}
