package pl.sda.wsumiedrogo.controllers;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.security.WebSecurityConfig;
import pl.sda.wsumiedrogo.service.RegistrationService;
import pl.sda.wsumiedrogo.service.UserService;
import pl.sda.wsumiedrogo.validator.UserValidator;

@Controller
public class RegisterController {


    WebSecurityConfig webSecurityConfig;
    UserService userService;
    RegistrationService registrationService;
    UserValidator userValidator;

    @Autowired
    public RegisterController(WebSecurityConfig webSecurityConfig, UserService userService,
                              RegistrationService registrationService, UserValidator userValidator) {
        this.webSecurityConfig = webSecurityConfig;
        this.userService = userService;
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String getRegister(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) throws EmailException {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        } else {

            return registrationService.registration(webSecurityConfig, userService, userForm);
        }
    }
}
