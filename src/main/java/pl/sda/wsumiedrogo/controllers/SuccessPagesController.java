package pl.sda.wsumiedrogo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuccessPagesController {
    @PostMapping("/successpage")
    public String successpage() {
        return "successpages/successpage";
    }
}