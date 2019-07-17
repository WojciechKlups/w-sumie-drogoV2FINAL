package pl.sda.wsumiedrogo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.UserRepository;

@Controller
public class HomeController {

    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index";
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

