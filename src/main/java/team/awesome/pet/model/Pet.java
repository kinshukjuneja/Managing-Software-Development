package team.awesome.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "shelter")
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
