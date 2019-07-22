package pl.sda.wsumiedrogo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("templates/header")
    public String header() {
        return "header";
    }

    @GetMapping("templates/footer")
    public String footer() {
        return "footer";
    }
}
