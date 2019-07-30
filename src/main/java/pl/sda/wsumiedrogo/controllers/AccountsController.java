package pl.sda.wsumiedrogo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.service.AccountService;
import pl.sda.wsumiedrogo.service.CookieService;
import pl.sda.wsumiedrogo.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountsController {
//aaa
    private AccountService accountService;
    private UserService userService;
    private CookieService cookieService;

    @Autowired
    public AccountsController(AccountService accountService, UserService userService, CookieService cookieService) {
        this.accountService = accountService;
        this.userService = userService;
        this.cookieService = cookieService;
    }

    @GetMapping("/account")
    public String getUserByEmail(HttpServletResponse response, @RequestParam String email, Model model, @ModelAttribute User user) {
        return accountService.getAccount(userService, model, email, cookieService, user, response);
    }
}
