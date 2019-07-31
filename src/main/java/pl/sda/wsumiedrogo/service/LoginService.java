package pl.sda.wsumiedrogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {

    private UserMapper userMapper;
    private CookieService cookieService;
    private UserService userService;

    @Autowired
    public LoginService(UserMapper userMapper, CookieService cookieService, UserService userService) {
        this.userMapper = userMapper;
        this.cookieService = cookieService;
        this.userService = userService;
    }

    public String isLoggedIn(HttpServletRequest request, String username, Model model){

        if (username.equals("default")) {
            return "login";
        } else {

            UserDto userDto = userService.getUserByEmail(username);

            model.addAttribute("user", userDto);
            cookieService.getUserFromCookie(request, username);

            return "account";
        }
    }
}
