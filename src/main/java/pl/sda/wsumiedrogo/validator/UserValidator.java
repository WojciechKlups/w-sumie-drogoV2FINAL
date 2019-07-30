package pl.sda.wsumiedrogo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.UserService;

@Component
public class UserValidator implements Validator {

    private UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

//        Checks if username is <6 >32 size and if someone already has that username in database
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.getUserByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }


//        Checks if password if <8 >32 length, contains any digit, any special mark and if password is repeated
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32
                && user.getPassword().matches("(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%&*()_+=|<>?{}\\[\\]~-])")) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }


//        Checks if phone number has 9 digits
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "NotEmpty");
        if (user.getPhoneNumber().toString().length() == 9 ){
            errors.rejectValue("phoneNumber", "Size.user.phoneNumber");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().contains("@")){
            errors.rejectValue("email", "Contains.user.email");
        }

    }
}
