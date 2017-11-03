package team.awesome.pet.service;

import team.awesome.pet.model.User;

public interface UserNewService {
  User findByUserName(String userName);

  void save(User user);
}
