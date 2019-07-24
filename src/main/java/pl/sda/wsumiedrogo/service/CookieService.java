package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    public void createCookie(HttpServletResponse response,User user){
        Cookie cookie = new Cookie("username", user.getFirstName());
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
    }
}
