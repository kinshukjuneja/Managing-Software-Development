package team.awesome.pet.model;

import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Represents a pet
 *
 */
@Builder
@Entity
@Table(name = "pet")
public class Pet {

  @Id
  @Column(name = "pet_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int petId;
  @Column(name = "pet_name")
  private String name;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User owner;
  @ManyToOne
  @JoinColumn(name = "tc_id")
  private PetType petType;
  @ManyToOne
  @JoinColumn(name = "shelter_id")
  private Shelter shelter;
  @Column(name = "pet_length")
  private double petLength;
  @Column(name = "pet_weight")
  private double petWeight;
  @Column(name = "pet_color")
  private String petColor;
  @Column(name = "health_status")
  private int healthStatus;
  @Column(name = "pet_location")
  private String currentLocation;

  public Pet() {}

  /**
   * Create a pet with many fields included petId, name, owner, pet type, pet length, pet weight,
   * pet color, health status and current pet location
   *
   * @param petId the id of a pet
   * @param name the name of a pet
   * @param owner the owner of a pet
   * @param petType the type of a pet
   * @param shelter the shelter where pet is
   * @param petLength the length of a pet
   * @param petWeight the weight of a pet
   * @param petColor the color of a pet
   * @param healthStatus the status of a pet's health
   * @param currentLocation the current location of a pet
   */
  public Pet(int petId, String name, User owner, PetType petType, Shelter shelter, double petLength,
      double petWeight, String petColor, int healthStatus, String currentLocation) {
    super();
    this.petId = petId;
    this.name = name;
    this.owner = owner;
    this.petType = petType;
    this.shelter = shelter;
    this.petLength = petLength;
    this.petWeight = petWeight;
    this.petColor = petColor;
    this.healthStatus = healthStatus;
    this.currentLocation = currentLocation;
  }

  /**
   *
   * @return the id of a pet
   */
  public int getPetId() {
    return this.petId;
  }

  /**
   *
   * @param petId the id of a pet to be set
   */
  public void setPetId(int petId) {
    this.petId = petId;
  }

  /**
   *
   * @return the name of a pet
   */
  public String getName() {
    return this.name;
  }

  /**
   *
   * @param name the name of a pet to be set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @return the owner of a pet
   */
  public User getOwner() {
    return this.owner;
  }

  /**
   *
   * @param owner the owner of a pet to be set
   */
  public void setOwner(User owner) {
    this.owner = owner;
  }

  /**
   *
   * @return the type of a pet
   */
  public PetType getPetType() {
    return this.petType;
  }

  /**
   *
   * @param petType the type of a pet to be set
   */
  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  /**
   *
   * @return the shelter where pet is
   */
  public Shelter getShelter() {
    return this.shelter;
  }

  /**
   *
   * @param shelter the shelter of a pet to be set
   */
  public void setShelter(Shelter shelter) {
    this.shelter = shelter;
  }

  /**
   *
   * @return the length of a pet
   */
  public double getPetLength() {
    return this.petLength;
  }

  /**
   *
   * @param petLength the length of a pet to be set
   */
  public void setPetLength(double petLength) {
    this.petLength = petLength;
  }

  /**
   *
   * @return the weight of a pet
   */
  public double getPetWeight() {
    return this.petWeight;
  }

  /**
   *
   * @param petWeight the weight of a pet to be set
   */
  public void setPetWeight(double petWeight) {
    this.petWeight = petWeight;
  }

  /**
   *
   * @return the color of a pet
   */
  public String getPetColor() {
    return this.petColor;
  }

  /**
   *
   * @param petColor the color of a pet to be set
   */
  public void setPetColor(String petColor) {
    this.petColor = petColor;
  }

  /**
   *
   * @return the current health status of a pet
   */
  public int getHealthStatus() {
    return this.healthStatus;
  }

  /**
   *
   * @param healthStatus the health status of a pet to be set
   */
  public void setHealthStatus(int healthStatus) {
    this.healthStatus = healthStatus;
  }

  /**
   *
   * @return the current location of a pet
   */
  public String getCurrentLocation() {
    return this.currentLocation;
  }

  /**
   *
   * @param currentLocation the current location of a pet to be set
   */
  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId + ", " +
                "name='" + name + '\'' + ", " +
                "owner=" + owner + ", " +
                "petType=" + petType + ", " +
                "shelter=" + shelter + ", " +
                "petLength=" + petLength + ", " +
                "petWeight=" + petWeight + ", " +
                "petColor='" + petColor + '\'' + ", " +
                "healthStatus=" + healthStatus + ", " +
                "currentLocation='" + currentLocation + '\'' +
                '}';
    }
}
