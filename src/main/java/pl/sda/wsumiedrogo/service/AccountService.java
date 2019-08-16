package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;

import javax.servlet.http.HttpServletResponse;

@Service
public class AccountService {

    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public AccountService(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

//    public String getAccount(Model model,String email, User user,HttpServletResponse response) {
//        User userByEmail = userService.getUserByEmail(email);
//
//
//        model.addAttribute("user", userByEmail);
//
//        if (userByEmail.isActivated()) {
//            return "account";
//        } else {
//            return "failedlogin";
//        }

    public String getAccount(Authentication authentication, Model model){
        User userByEmail = userService.getUserByEmail(authentication.getName());
        model.addAttribute("user", userByEmail);

        if (userByEmail.isActivated()) {
            return "account";
        } else {
            return "failedlogin";
        }
    }
}
