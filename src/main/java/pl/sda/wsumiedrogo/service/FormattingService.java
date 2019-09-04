//package pl.sda.wsumiedrogo.service;
//
//import org.apache.commons.math3.util.Precision;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import pl.sda.wsumiedrogo.model.Product;
//
//import java.util.List;
//
//@Service
//public class FormattingService {
//
//    private ProductService productService;
//
//    @Autowired
//    public FormattingService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    public List<Product> formatedToDoublePrecisionPriceInProduct() {
//        List<Product> allProducts = productService.getAllProducts();
//
//        for (Product product : allProducts) {
//            product.setPrice(Precision.round(product.getPrice(), 2));
//        }
//        return allProducts;
//    }
//
//}
