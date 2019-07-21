package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.UserRepository;
import pl.sda.wsumiedrogo.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.dto.UserDto;

@Controller
public class HomeController {


    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public HomeController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/account")
    public String getUserByEmail(@RequestParam String email, Model model, @ModelAttribute User user){
        UserDto userDto = userService.getUserByEmail(email);
        model.addAttribute("user", userDto);
        // zmiana na true bo zalogowany
        user.setLoggedIn(true);
        return "account";
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String getRegister() {
        return "register";
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@ModelAttribute User user, Model model) {
        userService.createNewUser(user);
        model.addAttribute("user",user);
        return "successpage";
    }

    @PostMapping("/successpage")
    public String successpage() {
        return "successpage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(@ModelAttribute User user) {
        if(user.isLoggedIn() == true){
            return "checkout-logged user";
        } else {
            return "checkout-unknown user";
        }
        //jesli zalogowany to checkout dla zalogowanego
        //jesli nie to checkout dla niezalogowanego

    }

    @GetMapping("/store")
    public String store() {
        return "store";
    }
}

