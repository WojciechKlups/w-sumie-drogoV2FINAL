package pl.sda.wsumiedrogo.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.ProductRepository;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class StoreController {

    ProductRepository productRepository;

    @Autowired
    public StoreController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/store")
    public String getStore() {
        return "store";
    }

    @GetMapping("/product")
    public String getProduct() {
        return "products/product";
    }

    @GetMapping("/addproduct")
    public String getAddProduct() {
        return "products/addproduct";
    }

    @GetMapping("/maczek")
    public String getMaczek(HttpServletResponse response, Model model,
                            @ModelAttribute Product product, Principal principal) {

        //@RequestParam String email
       // return productRepository.findByModelAndBrand();
        //return accountService.getAccount(model,principal.getName(),user,response);
        return "products/maczek";
    }
}
