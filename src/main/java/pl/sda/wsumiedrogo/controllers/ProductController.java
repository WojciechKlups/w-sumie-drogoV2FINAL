package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.wsumiedrogo.model.Product;
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

    @GetMapping("/product")
    public String showProduct() {
        return "products/product";
    }

    @GetMapping("/addproduct")
    public String getAddProduct() {
        return "products/addproduct";
    }

    @PostMapping("/addproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public String postAddProduct(@ModelAttribute Product product, Model model) {
        return productService.addProduct(product, model);
    }

}
