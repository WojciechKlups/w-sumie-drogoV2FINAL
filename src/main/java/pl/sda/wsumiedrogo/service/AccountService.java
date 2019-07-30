package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.sda.wsumiedrogo.mappers.UserMapper;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.HttpServletResponse;

@Service
public class AccountService {

    public String getAccount(UserService userService, Model model,
                             String email, CookieService cookieService, User user,
                             HttpServletResponse response, UserMapper userMapper) {
        User userByEmail = userService.getUserByEmail(email);

        UserDto userDto = userMapper.userToUserDto(userByEmail);
//        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        model.addAttribute("user", userDto);
        if (userDto.isActivated()) {
            cookieService.createCookie(response, user);
            return "account";
        } else {
            return "failedlogin";
        }
    }
}
