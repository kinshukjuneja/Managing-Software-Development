package team.awesome.pet.dao;

import team.awesome.pet.entity.User;

import java.util.Collection;

public interface UserDao {
    Collection<User> getAllUsers();

    User getUserById(int id);

    void updateUser(User user);

    void insertUserToDb(User user);

    void removeUserById(int id);
}
