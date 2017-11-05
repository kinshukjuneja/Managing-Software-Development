package team.awesome.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a shelter where all lost pets can be found
 *
 */
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

  /**
   * Create a shelter with all the needed information: shelterId, shelterName, description, status,
   * capacity, city, zipCode and location.
   *
   *
   * @param shelterId the id of the shelter
   * @param shelterName the name of the shelter
   * @param description any particular and special information about the shelter
   * @param status give the current status of the shelter
   * @param capacity how many pets it can hold
   * @param city the city of the shelter
   * @param zipCode the zip code of the shelter
   * @param location the location of where the shelter is
   */
  public Shelter(int shelterId, String shelterName, String description, boolean status,
      int capacity, String city, int zipCode, String location) {
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

  /**
   *
   * @return the id of the shelter
   */
  public int getShelterId() {
    return this.shelterId;
  }

  /**
   *
   * @param shelterId the id of the shelter to be set
   */
  public void setShelterId(int shelterId) {
    this.shelterId = shelterId;
  }

  /**
   *
   * @return the name of the shelter
   */
  public String getShelterName() {
    return this.shelterName;
  }

  /**
   *
   * @param shelterName the name of the shelter to be set
   */
  public void setShelterName(String shelterName) {
    this.shelterName = shelterName;
  }

  /**
   *
   * @return any particular and special information about the shelter
   */
  public String getDescription() {
    return this.description;
  }

  /**
   *
   * @param description special information about the shelter to be set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   *
   * @return the current status of the shelter
   */
  public boolean isStatus() {
    return this.status;
  }

  /**
   *
   * @param status the status of the shelter to be set
   */
  public void setStatus(boolean status) {
    this.status = status;
  }

  /**
   *
   * @return how many pets the shelter can hold
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   *
   * @param capacity the capacity of the shelter to be set
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   *
   * @return the city of the shelter
   */
  public String getCity() {
    return this.city;
  }

  /**
   *
   * @param city the city where the shelter is to be set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   *
   * @return the zip code of where the shelter is
   */
  public int getZipCode() {
    return this.zipCode;
  }

  /**
   *
   * @param zipCode the zip code of the shelter to be set
   */
  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

  /**
   *
   * @return the location of the shelter
   */
  public String getLocation() {
    return this.location;
  }

  /**
   *
   * @param location the location of the shelter to be set
   */
  public void setLocation(String location) {
    this.location = location;
  }

}
