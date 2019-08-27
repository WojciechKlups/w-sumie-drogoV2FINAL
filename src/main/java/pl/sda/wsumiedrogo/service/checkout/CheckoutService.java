package pl.sda.wsumiedrogo.service.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.UserService;

@Service
public class CheckoutService {

    private UserService userService;

    @Autowired
    public CheckoutService(UserService userService) {
        this.userService = userService;
    }

    public String getCheckoutUserForm(Authentication authentication, Model model) {
        if (authentication == null) {
            return "checkout-unknownuser";
        } else {
            User userByEmail = userService.getUserByEmail(authentication.getName());
            model.addAttribute("user", userByEmail);
            return "checkout-loggeduser";
        }
    }
}





//    public String checkout(User user)
//    {
//            return "checkout-loggeduser";
//    }
//}
