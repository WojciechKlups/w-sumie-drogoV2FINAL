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

    @GetMapping("/register")
    public String getRegister(@RequestParam User user) {
        user = new User();
        return "register";
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String postRegister(@RequestParam User user) {

        userService.createNewUser(user);
        return "success";
    }

    @PostMapping("/successpage")
    public String successpage() {

        return "successpage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/account")
    public String account() {
        return "account";
    }

    @GetMapping("/account")
    public String accountinfo(Model model){
        model.addAttribute("user", userRepository.getOne(1L));
        return "account";
    }
}

