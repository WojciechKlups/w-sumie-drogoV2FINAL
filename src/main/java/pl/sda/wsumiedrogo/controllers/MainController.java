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

    private WebSecurityConfig webSecurityConfig;
    private UserService userService;
    private CookieService cookieService;
    private UserDetailsServiceImpl userDetailsService;
    private LoginService loginService;
    private CheckoutService checkoutService;
    private RegistrationService registrationService;

    @Autowired
    public MainController(CookieService cookieService, UserService userService, WebSecurityConfig webSecurityConfig,
                          UserDetailsServiceImpl userDetailsService, LoginService loginService,
                          CheckoutService checkoutService,RegistrationService registrationService) {
        this.userService = userService;
        this.cookieService = cookieService;
        this.webSecurityConfig = webSecurityConfig;
        this.userDetailsService = userDetailsService;
        this.loginService = loginService;
        this.checkoutService = checkoutService;
        this.registrationService = registrationService;
    }


    @GetMapping("/")
    public String home(@CookieValue(value = "username", defaultValue = "default") String username) {

        return "index";
    }

    @GetMapping("/account")
    public String getUserByEmail(Principal principal, HttpServletResponse response, @RequestParam String email, Model model, @ModelAttribute User user) {
        //W pierwszej wersji podajemy UserDto i z niego odczytujemy wszystkie dane
        UserDto userDto = userService.getUserByEmail(email);

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        model.addAttribute("user", userDto);
        if (userDto.isActivated()) {

            cookieService.createCookie(response, user);

            return "account";
        } else {
            return "failedlogin";
        }
    }

    @GetMapping("/store")
    public String getStore() {
        return "store";
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String getRegister() {
        return "register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute User user, Model model) throws EmailException {
        return registrationService.registration(webSecurityConfig,userService,user,model);
    }


    @GetMapping("/login")
    public String login(HttpServletRequest request,
                        @CookieValue(value = "username", defaultValue = "default") String username, Model model) {

        return loginService.isLoggedIn(request, username, userService, model, cookieService);

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName();
//        model.addAttribute("user",name);

    }


    @GetMapping("/checkout")
    public String checkout(@ModelAttribute User user) {

        return checkoutService.checkout(user);
    }
}

