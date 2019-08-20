package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.Product;

@Service
public class AddProductService {

    private ProductService productService;

    @Autowired
    public AddProductService(ProductService productService) {
        this.productService = productService;
    }

    public String addProduct(Product product, Model model){
        productService.addNewProduct(product);
        model.addAttribute("product", product);
        return "successpages/successpage";
    }

}
