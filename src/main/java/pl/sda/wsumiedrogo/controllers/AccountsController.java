package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.AccountService;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class AccountsController {

    private AccountService accountService;


    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;

    }

    //HttpServletResponse response, Model model,
    //                                 @ModelAttribute User user, Principal principal

    //@RequestParam String email
    @GetMapping("/account")
    public String getUserByEmail(Model model, Authentication authentication) {
        return accountService.getAccount(authentication, model);
    }
}
