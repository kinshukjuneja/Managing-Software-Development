package team.awesome.pet.dao;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.model.Shelter;

@Repository
@Qualifier("mockShelterData")
public class MockShelterDaoImp implements ShelterDao {
  private static Map<BigInteger, Shelter> shelters;

  static {
    MockShelterDaoImp.shelters = new HashMap<BigInteger, Shelter>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

//      {
//        put(new BigInteger("1"),
//            new Shelter(new BigInteger("12345"), "Seattle-Shelter", true, 10000, "Seattle", 98005));
//        put(new BigInteger("2"),
//            new Shelter(new BigInteger("12346"), "Bellevue-Shelter", true, 500, "Bellevue", 98225));
//        put(new BigInteger("3"),
//            new Shelter(new BigInteger("12347"), "Tacome-Shelter", true, 5000, "Tacoma", 98554));
//      }
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
    Shelter s = MockShelterDaoImp.shelters.get(shelter.getShelterId());
//    s.setName(shelter.getName());
    s.setZipCode(shelter.getZipCode());
//    MockShelterDaoImp.shelters.put(shelter.getShelterId(), shelter);
  }

  @Override
  public void insertShelterToDb(Shelter shelter) {
//    MockShelterDaoImp.shelters.put(shelter.getShelterId(), shelter);
  }

  @Override
  public void removeShelterById(BigInteger id) {
    MockShelterDaoImp.shelters.remove(id);
  }

}
