package team.awesome.pet.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import team.awesome.pet.dao.UserDao;
import team.awesome.pet.model.User;
import team.awesome.pet.repository.UserRepository;

@Service
public class UserService {

  @Autowired
//  @Qualifier("mockUserData")
//  private UserDao userDao;
  	private UserRepository userRepository;

  	public Collection<User> getAllUsers() {
  		return this.userRepository.findAll();
  	}

  	public User getUserById(int id) {
  		return this.userRepository.findOne(id);
  	}

  	public void updateUser(User user) {
  		this.userRepository.save(user);
  	}

  	public void insertUser(User user) {
  		this.userRepository.save(user);
  	}

  	public void removeUserById(int id) {
  		this.userRepository.delete(id);
  	}
}
