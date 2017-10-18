package team.awesome.pet.model;

public class Pet {

  private int id;
  private String name;
  private String shelter;

  public Pet(int id, String name, String shelter) {
    this.id = id;
    this.name = name;
    this.shelter = shelter;
  }

  public Pet() {}

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
   * @return the shelter
   */
  public String getShelter() {
    return this.shelter;
  }

  /**
   * @param shelter the shelter to set
   */
  public void setShelter(String shelter) {
    this.shelter = shelter;
  }


}
