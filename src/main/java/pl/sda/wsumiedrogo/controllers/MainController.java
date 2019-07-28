package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.wsumiedrogo.service.CookieService;
import pl.sda.wsumiedrogo.service.LoginService;
import pl.sda.wsumiedrogo.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private UserService userService;
    private CookieService cookieService;
    private LoginService loginService;

    @Autowired
    public MainController(CookieService cookieService, UserService userService, LoginService loginService) {

        this.userService = userService;
        this.cookieService = cookieService;
        this.loginService = loginService;
    }


    @GetMapping("/")
    public String home(@CookieValue(value = "username", defaultValue = "default") String username) {

        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request,
                        @CookieValue(value = "username", defaultValue = "default") String username, Model model) {

        return loginService.isLoggedIn(request, username, userService, model, cookieService);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        model.addAttribute("user",name);

    }
}

