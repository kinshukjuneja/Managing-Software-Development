package team.awesome.pet.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import team.awesome.pet.model.User;
import team.awesome.pet.service.UserNewService;

@Service
public class UserValidator implements Validator {

  @Autowired
  private UserNewService userNewService;

  @Override
  public boolean supports(Class<?> nClass) {
    return User.class.equals(nClass);
  }

  @Override
  public void validate(Object obj, Errors err) {
    User user = (User) obj;

    ValidationUtils.rejectIfEmptyOrWhitespace(err, "username", "AvoidEmpty");
    if ((user.getUsername().length() < 6) || (user.getUsername().length() > 32)) {
      err.rejectValue("username", "Size.userForm.username");
    }
    if (this.userNewService.findByUserName(user.getUsername()) != null) {
      err.rejectValue("username", "Duplicate.userForm.username");
    }
    ValidationUtils.rejectIfEmptyOrWhitespace(err, "password", "AvoidEmpty");
    if ((user.getPassword().length() < 8) || (user.getPassword().length() > 32)) {
      err.rejectValue("password", "Size.userForm.password");
    }

    // if (!user.getPasswordConfirm().equals(user.getPassword())) {
    // err.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
    // }

  }

}
