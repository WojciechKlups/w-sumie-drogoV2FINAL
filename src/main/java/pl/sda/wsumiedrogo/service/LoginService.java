package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {


    public String isLoggedIn(HttpServletRequest request, String username,
                             UserService userService, Model model,
                             CookieService cookieService, UserMapper userMapper){

        if (username.equals("default")) {
            return "login";
        } else {

            User user = userService.getUserByEmail(username);
            UserDto userDto = userMapper.userToUserDto(user);
            model.addAttribute("user", userDto);
            cookieService.getUserFromCookie(request, username);

            return "account";
        }
    }
}
