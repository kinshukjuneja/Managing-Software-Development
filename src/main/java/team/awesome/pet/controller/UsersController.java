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

/**
 * This represents the Controller layer for User which will be used as a mean to communicate to the
 * Service layer to handle all the HTTP request
 *
 */
@Controller
public class UsersController {
  @Autowired
  private UserNewService userNewService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private UserValidator userValidator;

  /**
   * Assists an user to a registration form to register for an account
   *
   * @param model a model used to help with register an account for an UI purpose
   * @return an user form to fill out for an account
   */
  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String registration(Model model) {
    model.addAttribute("userForm", new User());
    return "registration";
  }

  /**
   * Assists to validate whether an account can be registered
   *
   * @param userForm a form for an user to fill out
   * @param bindingResult a result to verify
   * @param model a model used to help with register an account for an UI purpose
   * @return a new account if an account can be registered successfully
   */
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

  /**
   * Represents a login form for an user to log in
   *
   * @param model a model used to help with log in for an UI purpose
   * @param error an error message
   * @param logout a log out message
   * @return successful message if an user can log in or log out
   */
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

  /**
   * Represents a welcome portal
   *
   * @param model a model used for an UI purpose
   * @return a welcome page to let an user knows that he/she successfully logs in
   */
  @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
  public String welcome(Model model) {
    return "welcome";
  }
}
