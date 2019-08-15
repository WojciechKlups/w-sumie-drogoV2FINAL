package pl.sda.wsumiedrogo.service.checkout;

import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.User;

@Service
public class CheckoutService {
    public String checkout(User user)
    {
            return "checkout-loggeduser";
    }
}
