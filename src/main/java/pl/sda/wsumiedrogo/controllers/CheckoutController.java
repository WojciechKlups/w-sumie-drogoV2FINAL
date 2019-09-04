package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.checkout.CheckoutService;

@Controller
public class CheckoutController {

    CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping("/checkout")
    public String checkout(Model model, Authentication authentication) {

        return checkoutService.getCheckoutUserForm(authentication, model);
    }

}
