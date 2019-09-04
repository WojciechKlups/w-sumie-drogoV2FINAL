package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //https://www.baeldung.com/spring-thymeleaf-pagination

    public Optional<Product> findProduct(Long id) {
        return productRepository.findById(id);
    }

    //TODO: Searching engine https://www.baeldung.com/hibernate-search
    public Page<Product> getAllProducts(Optional<String> brand,
                                        Optional<Integer> currentpage,
                                        Optional<Integer> pageSize,
                                        Optional<String> sortBy) {
        return productRepository.findByBrand(brand.orElse("_"),
                PageRequest.of(currentpage.orElse(0), pageSize.orElse(9), Sort.Direction.ASC, sortBy.orElse("id")));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<Product> findPaginated(Pageable pageable) {
        final List<Product> allProducts = getAllProducts();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;

        if(allProducts.size() < startItem){
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize,allProducts.size());
            list = allProducts.subList(startItem,toIndex);
        }

        return new PageImpl<>(list,PageRequest.of(currentPage,pageSize),allProducts.size());
    }

    public String addProduct(Product product, Model model) {
        productRepository.save(product);
        model.addAttribute("product", product);
        return "successpages/successpage";
    }
}
