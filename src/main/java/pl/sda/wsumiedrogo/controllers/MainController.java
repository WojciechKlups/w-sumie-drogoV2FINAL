package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.wsumiedrogo.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MainController {

    private LoginService loginService;

    @Autowired
    public MainController(LoginService loginService) {

        this.loginService = loginService;

    }

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

        //return loginService.isLoggedIn(request, username, model);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        model.addAttribute("user",name);

    }
}

