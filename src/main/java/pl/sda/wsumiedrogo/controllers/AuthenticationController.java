package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.service.UserService;

@Controller
public class AuthenticationController {

    private UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/activate")
    public String authentication(@RequestParam(name = "code") String activationCode){
        userService.authenticate(activationCode);
        return "authentication-success";
    }

}
