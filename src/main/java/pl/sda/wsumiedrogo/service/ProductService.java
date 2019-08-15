package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.repositories.ProductRepository;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public String getProduct(Model model, String email, Product product, HttpServletResponse response) {
//        Product productByModelAndBrand = productRepository.findByModelAndBrand(product.getModel(),product.getBrand());
//
//
//        return ;
//    }
}
