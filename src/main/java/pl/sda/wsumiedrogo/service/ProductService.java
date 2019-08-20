package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    //https://github.com/nickazua/Spring-MVC-Beginners-App/blob/master/webstore/src/main/java/com/packt/webstore/controller/ProductController.java

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
        //TODO: ZAJRZYJ I LINK U GÓRY
    }
}
