package pl.sda.wsumiedrogo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuccessPagesController {
    @GetMapping("/successpage")
    public String successpage() {
        return "successpages/successpage";
    }
    @GetMapping("/successlogout")
    public String successlogout() {
        return "successpages/successlogout";
    }
    @GetMapping("/successcheckout")
    public String successcheckout() {
        return "successpages/successcheckout";
    }
}
