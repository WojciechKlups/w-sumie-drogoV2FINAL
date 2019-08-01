package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Cart;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.CartRepository;
import pl.sda.wsumiedrogo.repositories.ProductsRepository;

import java.util.Set;

@Service
public class CartService {

    private CartRepository cartRepository;
    private ProductsRepository productsRepository;


    @Autowired
    public CartService(CartRepository cartRepository, ProductsRepository productsRepository) {
        this.cartRepository = cartRepository;
        this.productsRepository = productsRepository;
    }

    public Cart createNewCart(){
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    public void addProduct(String productName) {
        Product byName = productsRepository.findByName(productName);
        boolean isAnyCartExisting = cartRepository.existsById(1L);
        if (!isAnyCartExisting) {
            Cart newCart = createNewCart();
            newCart.getProducts().add(byName);
            cartRepository.save(newCart);
        } else {
            Cart existingCart = cartRepository.getOne(1L);
            existingCart.getProducts().add(byName);
            cartRepository.save(existingCart);
        }
    }

    public Cart removeProduct(Product product){
        Cart existingCart = cartRepository.getOne(1L);
        existingCart.getProducts().remove(product);
        return cartRepository.save(existingCart);
    }

    public Set<Product> getAllProductsFromCart(Cart cart){
        return cart.getProducts();
    }
}
