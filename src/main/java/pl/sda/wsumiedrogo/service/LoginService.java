package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {


    public String isLoggedIn(HttpServletRequest request,String username,
                             UserService userService, Model model,
                             CookieService cookieService){

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
