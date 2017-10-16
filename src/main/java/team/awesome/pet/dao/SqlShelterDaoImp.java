package edu.neu.cs5500.animaltracking.dao;

import edu.neu.cs5500.animaltracking.entity.Shelter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("sqlData")
public class SqlShelterDaoImp implements ShelterDao {

    @Override
    public Collection<Shelter> getAllShelters() {
        return new ArrayList<Shelter>(){
            {
                add(new Shelter(1, "Downtown-Shelter"));
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
