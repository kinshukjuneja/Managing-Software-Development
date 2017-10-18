package team.awesome.pet.dao.jpa;

import java.util.Collection;

import team.awesome.pet.dao.UserDao;
import team.awesome.pet.model.User;

/**
 *
 * TODO: Implementing all the methods using Jpa repo. so that we can have better a service control
 * to interact with db and web services
 *
 */

public class JpaUserDao implements UserDao {

  @Override
  public Collection<User> getAllUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User getUserById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateUser(User user) {
    // TODO Auto-generated method stub

  }

  @Override
  public void insertUserToDb(User user) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeUserById(int id) {
    // TODO Auto-generated method stub

  }

}
