package team.awesome.pet.model;

public class PetTypeAndCategory {
  private PetType type;
  private PetCategory category;

  public PetTypeAndCategory(PetType type, PetCategory category) {
    super();
    this.type = type;
    this.category = category;
  }

  /**
   * @return the type of the pet
   */
  public PetType getType() {
    return this.type;
  }

  /**
   * @param type the type of the pet to set
   */
  public void setType(PetType type) {
    this.type = type;
  }

  /**
   * @return the category of a pet belongs to
   */
  public PetCategory getCategory() {
    return this.category;
  }

  /**
   * @param category the category of a pet to set
   */
  public void setCategory(PetCategory category) {
    this.category = category;
  }


}
