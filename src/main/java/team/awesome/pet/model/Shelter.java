package team.awesome.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shelter")
public class Shelter {
	@Id
	@Column(name = "shelter_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shelterId;
	@Column(name = "shelter_name")
	private String shelterName;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private boolean status;
	@Column(name = "capacity")
	private int capacity;
	@Column(name = "city")
	private String city;
	@Column(name = "zipcode")
	private int zipCode;
	@Column(name = "location")
	private String location;

	public Shelter() {}

	public Shelter(int shelterId, String shelterName, String description, boolean status, int capacity, String city,
			int zipCode, String location) {
		super();
		this.shelterId = shelterId;
		this.shelterName = shelterName;
		this.description = description;
		this.status = status;
		this.capacity = capacity;
		this.city = city;
		this.zipCode = zipCode;
		this.location = location;
	}

	public int getShelterId() {
		return shelterId;
	}

	public void setShelterId(int shelterId) {
		this.shelterId = shelterId;
	}

	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
