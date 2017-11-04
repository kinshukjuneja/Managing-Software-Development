package team.awesome.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.awesome.pet.model.User;
import team.awesome.pet.service.SecurityService;
import team.awesome.pet.service.UserNewService;
import team.awesome.pet.validation.UserValidator;


@Controller
public class UsersController {
  @Autowired
  private UserNewService userNewService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private UserValidator userValidator;

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String registration(Model model) {
    model.addAttribute("userForm", new User());
    return "registration";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,
      Model model) {
    this.userValidator.validate(userForm, bindingResult);

    if (bindingResult.hasErrors()) {
      return "registration";
    }

    this.userNewService.save(userForm);

    this.securityService.autologin(userForm.getUsername(), userForm.getPassword());

    return "redirect:/welcome";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login(Model model, String error, String logout) {
    if (error != null) {
      model.addAttribute("error", "Please check your username and password again.");
    }
    if (logout != null) {
      model.addAttribute("message", "Congrats! Successfully logged out.");
    }
    return "login";
  }

  @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
  public String welcome(Model model) {
    return "Welcome to Pet Rescue Organization and your name is: ";
  }
}
