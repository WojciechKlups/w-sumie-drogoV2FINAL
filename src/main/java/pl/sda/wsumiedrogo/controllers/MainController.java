package pl.sda.wsumiedrogo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Authentication authentication,Principal principal) {

        return "index";
    }

    @GetMapping("/login")
    public String login() {
            return "login";
    }
}

