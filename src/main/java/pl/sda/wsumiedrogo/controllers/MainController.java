package pl.sda.wsumiedrogo.controllers;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.wsumiedrogo.model.Cart;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.security.UserDetailsServiceImpl;
import pl.sda.wsumiedrogo.security.WebSecurityConfig;
import pl.sda.wsumiedrogo.service.*;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

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

