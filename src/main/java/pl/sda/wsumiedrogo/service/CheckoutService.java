package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.User;

@Service
public class CheckoutService {
    public String checkout(User user)
    {
        if (user.isLoggedIn()) {
            return "checkout-loggeduser";
        } else {
            return "checkout-unknownuser";
        }
    }
}
