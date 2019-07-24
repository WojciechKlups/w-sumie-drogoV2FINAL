package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    public void createCookie(HttpServletResponse response, UserDto userDto){
        Cookie cookie = new Cookie("username", userDto.getEmail());
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
    }

    public Cookie getUserFromCookie(HttpServletRequest request, @CookieValue(value = "username", defaultValue = "default") String username) {
        Cookie[] cookies = request.getCookies();
        Cookie cookieUser = null;
        for (int i = 0; i <cookies.length ; i++) {
            String name = cookies[i].getName();
            if (name.equals(username)){
                cookieUser = cookies[i];
            }
        }
        return cookieUser;
    }

    public void deleteCookie(Cookie cookie,HttpServletResponse response ){
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public Cookie[] getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie[] notEmpty = new Cookie[cookies.length];
        if (cookies != null) {
            notEmpty = cookies;
        }
        return notEmpty;
    }
}
