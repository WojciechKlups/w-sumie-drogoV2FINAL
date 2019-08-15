package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.AccountService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class AccountsController {

    private AccountService accountService;


    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;

    }

    @GetMapping("/account")
    public String getUserByEmail(HttpServletResponse response, Model model,
                                 @ModelAttribute User user, Principal principal) {

        //@RequestParam String email
        return accountService.getAccount(model,principal.getName(),user,response);
    }
}
