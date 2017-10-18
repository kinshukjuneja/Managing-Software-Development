package team.awesome.pet.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.model.PetType;

@Repository
@Qualifier("mockPetTypeData")
public class MockPetTypeDaoImp implements PetTypeDao {

  private static Map<Integer, PetType> petTypes;

  static {
    MockPetTypeDaoImp.petTypes = new HashMap<Integer, PetType>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      {
        put(1, new PetType("dog"));
        put(2, new PetType("cat"));
        put(3, new PetType("other"));
      }
    };
  }

  @Override
  public Collection<PetType> getAllPetType() {
    return MockPetTypeDaoImp.petTypes.values();
  }

  @Override
  public PetType getPetTypeById(int id) {
    return MockPetTypeDaoImp.petTypes.get(id);
  }

  @Override
  public void updatePetType(PetType petType) {
    // PetType type = MockPetTypeData.petTypes.get(petType.getName());

  }

  @Override
  public void removePetType(int id) {
    MockPetTypeDaoImp.petTypes.remove(id);
  }

}
