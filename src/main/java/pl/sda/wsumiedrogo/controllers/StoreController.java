package pl.sda.wsumiedrogo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    @GetMapping("/stores")
    public String getStore() {
        return "store";
    }
}
