package team.awesome.pet.entity;

public class Shelter {
  private int id;
  private String name;
  private String description;
  private boolean status;
  private int capacity;
  private String city;
  private int zipCode;
  
  public Shelter() {

  }

  public Shelter(int id, String name, String description, boolean status, int capacity, int zipCode) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.status = status;
    this.capacity = capacity;
    this.zipCode = zipCode;
  }

  /**
   * @return the id
   */
  public int getId() {
    return this.id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
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
   *
   * @return the capacity
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   *
   * @param capacity
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   *
   * @return status i.e. active or not
   */
  public boolean isStatus() {
    return status;
  }

  /**
   *
   * @param status
   */

  public void setStatus(boolean status) {
    this.status = status;
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
   * @return the zip_code
   */
  public int getZip_code() {
    return this.zipCode;
  }

  /**
   * @param zip_code the zip_code to set
   */
  public void setZip_code(int zip_code) {
    this.zipCode = zipCode;
  }
}
