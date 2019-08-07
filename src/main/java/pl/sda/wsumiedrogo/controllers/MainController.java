package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.service.CookieService;
import pl.sda.wsumiedrogo.service.LoginService;
import pl.sda.wsumiedrogo.service.UserService;

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
    public String home(@CookieValue(value = "username", defaultValue = "default") String username) {

        return "index";
    }
    @GetMapping("/store")
    public String store(@CookieValue(value = "username", defaultValue = "default") String username) {

        return "store";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request,
                        @CookieValue(value = "username", defaultValue = "default") String username, Model model,
                        Principal principal) {

        Object principal1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(username.equals("default")){
            return "login";
        } else {
            return "account";
        }

        //return loginService.isLoggedIn(request, username, model);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        model.addAttribute("user",name);

    }
}

