package team.awesome.pet.entity;

public class Shelter {
  private int id;
  private String name;
  private String description;
  String city;
  private int zip_code;

  public Shelter() {

  }

  public Shelter(String name, String description, int zip_code) {
    this.name = name;
    this.description = description;
    this.zip_code = zip_code;
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
    return this.zip_code;
  }

  /**
   * @param zip_code the zip_code to set
   */
  public void setZip_code(int zip_code) {
    this.zip_code = zip_code;
  }



}
