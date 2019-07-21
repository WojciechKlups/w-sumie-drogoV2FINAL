package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.ProductsRepository;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductByName(String name) throws ResourceNotFoundException{
        return productsRepository.findByName(name);
    }
}
