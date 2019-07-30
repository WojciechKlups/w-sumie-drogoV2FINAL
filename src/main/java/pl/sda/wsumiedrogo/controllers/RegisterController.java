package pl.sda.wsumiedrogo.controllers;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.security.WebSecurityConfig;
import pl.sda.wsumiedrogo.service.RegistrationService;
import pl.sda.wsumiedrogo.service.UserService;

@Controller
public class RegisterController {


    WebSecurityConfig webSecurityConfig;
    UserService userService;
    RegistrationService registrationService;

    @Autowired
    public RegisterController(WebSecurityConfig webSecurityConfig, UserService userService, RegistrationService registrationService) {
        this.webSecurityConfig = webSecurityConfig;
        this.userService = userService;
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String getRegister() {
        return "register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute User user, Model model) throws EmailException {
        return registrationService.registration(webSecurityConfig, userService, user, model);
    }
}
