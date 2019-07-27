package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.Cart;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.CartService;
import pl.sda.wsumiedrogo.service.ProductsService;

@Controller
public class CartController {

    private CartService cartService;
    private ProductsService productsService;

    @Autowired
    public CartController(CartService cartService, ProductsService productsService) {
        this.cartService = cartService;
        this.productsService = productsService;
    }

    //NOT SURE IF IT SHOULD WORK LIKE THAT...

    @GetMapping("/cart")
    public String getAllProducts(@ModelAttribute Cart cart, Model model){
        cartService.getAllProductsFromCart(cart);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart/add")
    public String addProductToCart(@ModelAttribute User user, Model model){
        Product maczek = productsService.getProductByName("maczek");
        Cart cart = user.getCart();
        model.addAttribute("maczek", maczek);
        cartService.addProduct(maczek.getName());

        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart/remove")
    public String removeProductFromCart(@ModelAttribute Product product, Cart cart, Model model){
        cartService.removeProduct(product);
        model.addAttribute("cart", cart);
        return "cart";
    }
}
