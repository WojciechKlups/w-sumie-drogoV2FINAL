package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.service.UserService;

@Controller
public class AuthenticationController {

    UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/activate")
    public String auhentication(@RequestParam(name = "code") String activationCode){
        userService.autenticate(activationCode);
        return "successpages/authentication-success";
    }

    //serwis który dostanie jako param activation code (request param)
    //serwis wyszukuje usera, oznacza flagę jako true i zapisuje zmienione dane
}
