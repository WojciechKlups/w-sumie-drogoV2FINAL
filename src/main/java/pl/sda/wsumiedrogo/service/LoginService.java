package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {

    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public LoginService(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    public String isLoggedIn(HttpServletRequest request, String username, Model model){

        if (username.equals("default")) {
            return "login";
        } else {

            User user = userService.getUserByEmail(username);

            model.addAttribute("user", user);

            return "account";
        }
    }
}
