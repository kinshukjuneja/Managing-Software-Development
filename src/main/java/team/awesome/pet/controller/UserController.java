package team.awesome.pet.controller;

/**
 * ctran - Will not need this class since we're not sure about roles Thus using the other class
 * UsersController is more benefit in term of routing and setting up front page for this project.
 * Will leave this class here for now as a backup.
 */


import java.util.Collection;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.User;
import team.awesome.pet.service.ShelterService;
import team.awesome.pet.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  // private UserRepository userRepository;
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public Collection<User> getAllUsers() {
    return this.userService.getAllUsers();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User getUserById(@PathVariable("id") int id) {
    return this.userService.getUserById(id);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateUser(@RequestBody User user) {
    this.userService.updateUser(user);
  } //was calling insertUser here earlier which introduced a bug and showed up in test.

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertUser(@RequestBody User user) {
    this.userService.insertUser(user);
  } //was calling updateUser here earlier which introduced a bug and showed up in test.

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteUserById(@PathVariable("id") int id) {
    this.userService.removeUserById(id);
  }
}
