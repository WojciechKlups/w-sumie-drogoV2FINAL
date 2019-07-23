package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.sda.wsumiedrogo.model.Cart;
import pl.sda.wsumiedrogo.model.Product;
import pl.sda.wsumiedrogo.service.CartService;

@Controller
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //NOT SURE IF IT SHOULD WORK LIKE THAT...

    @GetMapping("/cart")
    public String getAllProducts(@ModelAttribute Cart cart, Model model){
        cartService.getAllProductsFromCart(cart);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/cart/add")
    public String addProductToCart(@ModelAttribute Product product, Cart cart, Model model){
        cartService.addProduct(product);
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
