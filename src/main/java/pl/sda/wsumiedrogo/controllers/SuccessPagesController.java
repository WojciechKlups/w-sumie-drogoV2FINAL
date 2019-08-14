package pl.sda.wsumiedrogo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/failedlogin")
    public String failedlogin() {
        return "successpages/failedlogin";
    }

//    @GetMapping("/successcheckout")
//    public String successcheckout() {
//        return "successpages/successcheckout";
//    }
}
