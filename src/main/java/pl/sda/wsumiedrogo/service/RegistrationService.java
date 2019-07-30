package pl.sda.wsumiedrogo.service;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.security.WebSecurityConfig;

@Service
public class RegistrationService {

    public String registration(WebSecurityConfig webSecurityConfig, UserService userService, User user) throws EmailException {
        user.setPassword(webSecurityConfig
                .passwordEncoder()
                .encode(user.getPassword()));
        userService.createNewUser(user);
//        model.addAttribute("user", user);
        return "successpages/successpage";
    }

}
