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

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/store")
    public String allProducts(
            //@RequestParam Optional<String> name,
                              @RequestParam Optional<Integer> page,
                              @RequestParam Optional<String> sortBy,
                              Model model){

        model.addAttribute("products",productService.getAllProducts(
                //name,
                page,sortBy));
        return "store";
    }

}
