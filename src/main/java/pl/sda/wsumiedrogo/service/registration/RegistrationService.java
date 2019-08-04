package pl.sda.wsumiedrogo.service.registration;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.security.WebSecurityConfig;
import pl.sda.wsumiedrogo.service.UserService;

@Service
public class RegistrationService {

    private WebSecurityConfig webSecurityConfig;
    private UserService userService;

    @Autowired
    public RegistrationService(WebSecurityConfig webSecurityConfig, UserService userService) {
        this.webSecurityConfig = webSecurityConfig;
        this.userService = userService;
    }

    public String registration(User user, Model model) throws EmailException {
        user.setPassword(webSecurityConfig
                .passwordEncoder()
                .encode(user.getPassword()));
        userService.createNewUser(user);
        model.addAttribute("user", user);
        return "successpages/successpage";
    }

}
