package team.awesome.pet.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.entity.Shelter;

@Repository
@Qualifier("mockShelterData")
public class MockShelterData implements ShelterRepository {
  private static Map<Integer, Shelter> shelters;

  static {
    MockShelterData.shelters = new HashMap<Integer, Shelter>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      {
        put(1, new Shelter("Seattle-Shelter", "Only takes in dogs", 98005));
        put(2, new Shelter("Bellevue-Shelter", "Opens to all pets", 98025));
        put(3, new Shelter("Tacoma-Shelter", "Opens to cats only", 59001));
      }
    };
  }

  @Override
  public Collection<Shelter> getAllShelter() {
    return MockShelterData.shelters.values();
  }

  @Override
  public Shelter getShelterById(int id) {
    return MockShelterData.shelters.get(id);
  }

  @Override
  public void addShelterToDb(Shelter shelter) {
    MockShelterData.shelters.put(shelter.getId(), shelter);
  }

  @Override
  public void updateShelter(Shelter shelter) {
    Shelter s = MockShelterData.shelters.get(shelter.getId());
    s.setName(shelter.getName());
    s.setZip_code(shelter.getZip_code());
    MockShelterData.shelters.put(shelter.getId(), shelter);
  }

  @Override
  public void removeShelterById(int id) {
    MockShelterData.shelters.remove(id);
  }

}
