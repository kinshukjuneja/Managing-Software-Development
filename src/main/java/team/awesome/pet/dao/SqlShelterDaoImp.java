package team.awesome.pet.dao;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import team.awesome.pet.entity.Shelter;

import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("sqlData")
public class SqlShelterDaoImp implements ShelterDao {

    @Override
    public Collection<Shelter> getAllShelters() {
        return new ArrayList<Shelter>(){
            {
                add(new Shelter(1,"Seattle-Shelter", "Only takes in dogs", 98005));
            }
        };
    }

    @Override
    public Shelter getShelterById(int id) {
        return null;
    }

    @Override
    public void updateShelter(Shelter shelter) {

    }

    @Override
    public void insertShelterToDb(Shelter shelter) {

    }

    @Override
    public void removeShelterById(int id) {

    }
}
