package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.service.ProductService;

import java.util.Optional;

@Controller
public class ProductController {

    //https://o7planning.org/en/10683/create-a-shopping-cart-web-application-with-spring-boot-hibernate#a14223413

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/store")
    public String allProducts( @RequestParam Optional<String> brand,
                              @RequestParam Optional<Integer> page,
                              @RequestParam Optional<String> sortBy,
                              Model model){

        model.addAttribute("products",productService.getAllProducts(brand,page,sortBy));
        return "store";
    }

}
