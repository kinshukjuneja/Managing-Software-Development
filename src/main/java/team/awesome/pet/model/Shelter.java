package team.awesome.pet.model;

import java.math.BigInteger;

public class Shelter extends Name {
  // private int id;
  // private String name;
  private BigInteger shelterId;
  private String description;
  private boolean status;
  private int capacity;
  private String city;
  private int zipCode;

  public Shelter() {

  }

  public Shelter(BigInteger shelterId, String description, boolean status, int capacity,
      String city, int zipCode) {
    super();
    this.shelterId = shelterId;
    this.description = description;
    this.status = status;
    this.capacity = capacity;
    this.city = city;
    this.zipCode = zipCode;
  }

  /**
   * @return the shelterId
   */
  public BigInteger getShelterId() {
    return this.shelterId;
  }

  /**
   * @param shelterId the shelterId to set
   */
  public void setShelterId(BigInteger shelterId) {
    this.shelterId = shelterId;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the status
   */
  public boolean isStatus() {
    return this.status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(boolean status) {
    this.status = status;
  }

  /**
   * @return the capacity
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * @param capacity the capacity to set
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return this.city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the zipCode
   */
  public int getZipCode() {
    return this.zipCode;
  }

  /**
   * @param zipCode the zipCode to set
   */
  public void setZipCode(int zipCode) {
    this.zipCode = zipCode;
  }

}
