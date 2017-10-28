package team.awesome.pet.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.awesome.pet.model.User;
import team.awesome.pet.repository.UserRepository;
import team.awesome.pet.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
//  private UserRepository userRepository;
	private UserService userService;

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
		this.userService.insertUser(user);
	 }

 	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 	public void insertUser(@RequestBody User user) {
 		this.userService.updateUser(user);
 	}

 	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
 	public void deleteUserById(@PathVariable("id") int id) {
 		this.userService.removeUserById(id);
 	}
}
