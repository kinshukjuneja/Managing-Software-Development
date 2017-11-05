package team.awesome.pet.service;

import team.awesome.pet.model.User;

/**
 * Represents a special service for an user
 *
 *
 */
public interface UserNewService {

  /**
   * Assists to find user by his/her username
   *
   * @param userName the username of an user
   * @return the specific user with a matching username
   */
  User findByUserName(String userName);

  /**
   * Save an user with an updated information
   *
   * @param user the user who needs to have his/her information updated
   */
  void save(User user);
}
