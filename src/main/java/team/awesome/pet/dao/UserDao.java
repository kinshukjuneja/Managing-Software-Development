package team.awesome.pet.dao;

import java.util.Collection;

import team.awesome.pet.model.User;

public interface UserDao {
  Collection<User> getAllUsers();

  User getUserById(int id);

  void updateUser(User user);

  void insertUserToDb(User user);

  void removeUserById(int id);
}
