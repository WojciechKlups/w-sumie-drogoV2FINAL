package pl.sda.wsumiedrogo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
    @GetMapping("/maczek")
    public String getMaczek() {
        return "products/maczek";
    }
    @GetMapping("/sluchawki")
    public String getSluchawki() {
        return "products/sluchawki";
    }

}
