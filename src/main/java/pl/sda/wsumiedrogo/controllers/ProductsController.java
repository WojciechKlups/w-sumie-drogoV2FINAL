package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.service.ProductsService;

@Controller
public class ProductsController {
    private ProductsService productsService;
    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/maczek")
    public String getMaczek( Model model) {
        return "products/maczek";
    }

    @GetMapping("/sluchawki")
    public String getSluchawki() {
        return "products/sluchawki";
    }

//    @GetMapping("/products/{name}")
//    public String getProduct(@ModelAttribute Model model, @PathVariable("name")String name)
//    {
//        model.addAttribute("product", productService.getProductByName(name));
//        return "products/{name}";
//    }
}
