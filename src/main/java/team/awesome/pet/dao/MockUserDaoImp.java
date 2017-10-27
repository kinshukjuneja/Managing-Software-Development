package team.awesome.pet.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import team.awesome.pet.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import team.awesome.pet.model.User;

@Repository
@Qualifier("mockUserData")
public class MockUserDaoImp implements UserDao {
  private static Map<Integer, User> users;
  static {
    MockUserDaoImp.users = new HashMap<Integer, User>() {

      /**
       *
       */
      private static final long serialVersionUID = 1L;

      {
        put(1, new User(1, "Kinshuk", "Awesome1"));
        put(2, new User(2, "John", "Awesome2"));
        put(3, new User(3, "Guohan", "Awesome3"));
      }
    };
  }

  @Override
  public Collection<User> getAllUsers() {
    return MockUserDaoImp.users.values();
  }

  @Override
  public User getUserById(int id) {
    return MockUserDaoImp.users.get(id);
  }

  @Override
  public void updateUser(User user) {
    User u = MockUserDaoImp.users.get(user.getId());
    u.setName(user.getName());
    u.setPassword(user.getPassword());
    MockUserDaoImp.users.put(user.getId(), user);
  }

  @Override
  public void insertUserToDb(User user) {
    MockUserDaoImp.users.put(user.getId(), user);
  }

  @Override
  public void removeUserById(int id) {
    MockUserDaoImp.users.remove(id);
  }
}
