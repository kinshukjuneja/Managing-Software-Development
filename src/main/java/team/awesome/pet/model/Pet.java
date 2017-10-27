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

}
