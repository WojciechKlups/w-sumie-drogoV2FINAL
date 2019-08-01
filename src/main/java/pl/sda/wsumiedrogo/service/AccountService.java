package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.HttpServletResponse;

@Service
public class AccountService {

    private UserMapper userMapper;
    private UserService userService;
    private CookieService cookieService;

    @Autowired
    public AccountService(UserMapper userMapper, UserService userService, CookieService cookieService) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.cookieService = cookieService;
    }

    public String getAccount(Model model,String email, User user,HttpServletResponse response) {
        User userByEmail = userService.getUserByEmail(email);


        model.addAttribute("user", userByEmail);
        //TODO Zmiana na user DTO powoduje, że nie posiada on pola isActivated. Prawdopodobnie poprawa logowania powinna temu zaradzić
        if (userByEmail.isActivated()) {
            cookieService.createCookie(response, user);
            return "account";
        } else {
            return "failedlogin";
        }
    }
}
