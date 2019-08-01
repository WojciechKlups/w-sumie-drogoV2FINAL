package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.AccountService;


import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountsController {

    private AccountService accountService;


    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;

    }

    @GetMapping("/account")
    public String getUserByEmail(HttpServletResponse response, @RequestParam String email, Model model,
                                 @ModelAttribute User user) {
        return accountService.getAccount(model,email,user,response);
    }
}
