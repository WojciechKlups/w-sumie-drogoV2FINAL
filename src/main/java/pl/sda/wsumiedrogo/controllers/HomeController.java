package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public String getUserByEmail(@RequestParam String email, Model model){
        UserDto userDto = userService.getUserByEmail(email);
        model.addAttribute("user", userDto);
        return "account";
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@RequestParam User user,Model model) {
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


}

