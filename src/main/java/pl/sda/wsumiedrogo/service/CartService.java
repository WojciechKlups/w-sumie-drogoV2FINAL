package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Cart;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.repositories.CartRepository;

import java.util.Set;

@Service
public class CartService {

    private CartRepository cartRepository;
    private Cart cart = new Cart();

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addProduct(Product product){
        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }

    public Cart removeProduct(Product product){
        cart.getProducts().remove(product);
        return cartRepository.save(cart);
    }

    public Set<Product> getAllProductsFromCart(Cart cart){
        return cart.getProducts();
    }
}
