package pl.sda.wsumiedrogo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    //testing commits and pushes

    @GetMapping("/")
    public String home(Authentication authentication,Principal principal) {

        return "index";
    }

    @GetMapping("/store")
    public String store() {

        return "store";
    }

    @GetMapping("/login")
    public String login(Authentication authentication) {
            return "login";
    }
}

