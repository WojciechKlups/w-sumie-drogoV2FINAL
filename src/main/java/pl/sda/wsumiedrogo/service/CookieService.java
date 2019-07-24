package pl.sda.wsumiedrogo.service;

import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    public void createCookie(HttpServletResponse response,User user){
        Cookie cookie = new Cookie("username", user.getFirstName());
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie){
        cookie.setMaxAge(0);
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
