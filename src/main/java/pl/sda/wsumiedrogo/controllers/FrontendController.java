package pl.sda.wsumiedrogo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

//    @GetMapping("pastedparts/header")
//    public String header() {
//        return "pastedparts/header";
//    }

    @GetMapping("templates/footer")
    public String footer() {
        return "footer";
    }
}
