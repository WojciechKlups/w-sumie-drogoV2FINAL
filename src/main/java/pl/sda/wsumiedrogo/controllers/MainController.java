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
    @GetMapping("/product")
    public String getProduct(Authentication authentication,Principal principal) {

        return "products/product";
    }
    @GetMapping("/login")
    public String login(Authentication authentication) {
            return "login";
    }
}

