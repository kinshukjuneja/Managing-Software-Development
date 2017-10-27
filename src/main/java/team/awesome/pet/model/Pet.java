package team.awesome.pet.model;

import java.math.BigInteger;

public class Pet extends Name {

  // TODO: Have to add in the correct field for Pet
  // private BigInteger petId instead of int petId
  private int petId;
  // private String name;
  private PetTypeAndCategory petTypeCategory;
  private BigInteger shelterId;
  private double pet_length;
  private double pet_weight;
  private String pet_color;
  private int health_status;
  // private Location current_location;

  public Pet(int petId, String name, BigInteger shelterId) {
    super();
    this.petId = petId;
    this.shelterId = shelterId;
  }

  public Pet() {}

  /**
   * @return the petId of a pet
   */
  public int getPetId() {
    return this.petId;
  }

  /**
   * @param petId the petId of a pet to set
   */
  public void setPetId(int petId) {
    this.petId = petId;
  }

  /**
   * @return the shelterId of a shelter
   */
  public BigInteger getShelterId() {
    return this.shelterId;
  }

  /**
   * @param shelterId the shelterId of a shelter to set
   */
  public void setShelterId(BigInteger shelterId) {
    this.shelterId = shelterId;
  }

}
