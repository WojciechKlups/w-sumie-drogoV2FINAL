package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.dto.UserDto;
import pl.sda.wsumiedrogo.service.UserService;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegister() {

        return "register";
    }

    @PostMapping("/register")
    public String postRegister() {

        return "register";
    }

    @GetMapping("/successpage")
    public String successpage() {
        return "successpage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/account")
    public UserDto getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }
}

