package team.awesome.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import team.awesome.pet.model.User;
import team.awesome.pet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserNewService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public User findByUserName(String userName) {
    return this.userRepository.findByUserName(userName);
  }

  @Override
  public void save(User user) {
    user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
    this.userRepository.save(user);
  }

}
