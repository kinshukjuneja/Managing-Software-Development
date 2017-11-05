package team.awesome.pet.service;

/**
 * Represents the security service to use for an user
 *
 */
public interface SecurityService {

  /**
   * Checking to find an username who might have already logged in
   *
   * @return an username who has already logged in
   */
  String findAlreadyUserNameLoggedIn();

  /**
   * Checking an user who might be log in automatically
   *
   * @param userName the username of an user
   * @param password the password of an user
   */
  void autologin(String userName, String password);

}
