package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.service.ProductService;
import pl.sda.wsumiedrogo.service.ResourceNotFoundException;

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
                               //@RequestParam Optional<Integer> page,
                               @RequestParam Optional<Integer> currentPage,
                               @RequestParam Optional<Integer> pageSize,
                               @RequestParam Optional<String> sortBy,
                               Model model){

        model.addAttribute("products",productService.getAllProducts(brand,currentPage,pageSize,sortBy));

        return "store";
    }

    @GetMapping("/product")
    public String showSpecificProduct(Model model, @RequestParam(value = "id", defaultValue = "") Long id) {

        model.addAttribute("product",productService.findProduct(id).orElseThrow(ResourceNotFoundException::new));

        return "products/product";

    }

    @GetMapping("/addtocart")
    public String addToCart() {
        return "products/addproduct";
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
