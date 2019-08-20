package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.service.AddProductService;


@Controller
public class AddProductController {

    private AddProductService addProductService;

    @Autowired
    public AddProductController(AddProductService addProductService) {
        this.addProductService = addProductService;
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

    @PostMapping("/addproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public String postAddProduct(@ModelAttribute Product product, Model model) {
        return addProductService.addProduct(product, model);
    }


}
