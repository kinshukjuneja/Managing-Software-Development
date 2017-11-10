package team.awesome.pet.service;

public interface SecurityService {

  String findAlreadyUserNameLoggedIn();

  void autologin(String userName, String password);

}
