package team.awesome.pet.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import team.awesome.pet.entity.Shelter;

@Repository
@Qualifier("mockShelterData")
public class MockShelterDaoImp implements ShelterDao {
  private static Map<Integer, Shelter> shelters;

  static {
    MockShelterDaoImp.shelters = new HashMap<Integer, Shelter>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      {
        put(1, new Shelter(1,"Seattle-Shelter", "Only takes in dogs", 98005));
        put(2, new Shelter(2,"Bellevue-Shelter", "Opens to all pets", 98025));
        put(3, new Shelter(3,"Tacoma-Shelter", "Opens to cats only", 59001));
      }
    };
  }

  @Override
  public Collection<Shelter> getAllShelters() {
    return MockShelterDaoImp.shelters.values();
  }

  @Override
  public Shelter getShelterById(int id) {
    return MockShelterDaoImp.shelters.get(id);
  }

  @Override
  public void updateShelter(Shelter shelter) {
    Shelter s = MockShelterDaoImp.shelters.get(shelter.getId());
    s.setName(shelter.getName());
    s.setZip_code(shelter.getZip_code());
    MockShelterDaoImp.shelters.put(shelter.getId(), shelter);
  }

  @Override
  public void insertShelterToDb(Shelter shelter) {
    MockShelterDaoImp.shelters.put(shelter.getId(), shelter);
  }

  @Override
  public void removeShelterById(int id) {
    MockShelterDaoImp.shelters.remove(id);
  }

}
