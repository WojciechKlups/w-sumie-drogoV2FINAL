package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //https://www.baeldung.com/spring-thymeleaf-pagination
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }
    public Page<Product> getAllProducts(){
        return productRepository.findAll(PageRequest.of(0,2));
    }
}
