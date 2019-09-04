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
import pl.sda.wsumiedrogo.service.registration.RegistrationService;
import pl.sda.wsumiedrogo.validators.UserRegistrationValidator;

@Controller
public class RegisterController {


    private RegistrationService registrationService;
    private UserRegistrationValidator userRegistrationValidator;

    @Autowired
    public RegisterController(RegistrationService registrationService, UserRegistrationValidator userRegistrationValidator) {
        this.registrationService = registrationService;
        this.userRegistrationValidator = userRegistrationValidator;
    }


    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute("user") User user, BindingResult bindingResult,
                               Model model) throws EmailException {
        userRegistrationValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "register";
        }
        return registrationService.registration(user, model);
    }
}
