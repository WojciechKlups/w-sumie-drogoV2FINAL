package pl.sda.wsumiedrogo.controllers;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.wsumiedrogo.model.Cart;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.security.WebSecurityConfig;
import pl.sda.wsumiedrogo.service.CookieService;
import pl.sda.wsumiedrogo.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    private WebSecurityConfig webSecurityConfig;
    private UserService userService;
    private CookieService cookieService;

    @Autowired
    public MainController(CookieService cookieService, UserService userService, WebSecurityConfig webSecurityConfig) {
        this.userService = userService;
        this.cookieService = cookieService;
        this.webSecurityConfig = webSecurityConfig;
    }

    @GetMapping("/")
    public String home(@CookieValue(value = "username", defaultValue = "default") String username) {

        return "index";
    }


    @GetMapping("/isloggedin")
    public String isloggeedin(HttpServletRequest request,@CookieValue(value = "username", defaultValue = "default") String username, @ModelAttribute User user) {

        if (username.equals("default")) {
            return "login";
        } else {
            cookieService.getUserFromCookie(request, username);
            return "account";
        }
    }



    @GetMapping("/logouts")
    public String logout( HttpServletRequest request,HttpServletResponse response,@CookieValue(value = "username", defaultValue = "default") String username) {
        Cookie[] cookies = request.getCookies();

        for (int i = 0; i <cookies.length ; i++) {
             cookieService.deleteCookie(cookies[i],response);
        }


        return "successpages/successlogout";
    }

    @GetMapping("/account")
    public String getUserByEmail(HttpServletResponse response, @RequestParam String email, Model model, @ModelAttribute User user) {
        UserDto userDto = userService.getUserByEmail(email);
        model.addAttribute("user", userDto);
        if (userDto.isActivated()) {

            cookieService.createCookie(response, userDto);

            return "account";
        } else {
            return "failedlogin";
        }
    }


    @GetMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String getRegister() {
        return "register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute User user, Model model) throws EmailException {
        user.setPassword(webSecurityConfig
                .passwordEncoder()
                .encode(user.getPassword()));
        userService.createNewUser(user);
        model.addAttribute("user", user);
        return "successpages/successpage";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/checkout")
    public String checkout(@ModelAttribute User user) {

        if (user.isLoggedIn()) {
            return "checkout-logged user";
        } else {
            return "checkout-unknown user";
        }
    }

    @GetMapping("/store")
    public String store() {
        return "store";
    }
}

