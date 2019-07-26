package pl.sda.wsumiedrogo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //https://www.baeldung.com/spring-security-logout

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {

//.usernameParameter(&quot;username&quot;) // default is username
//	 * 				.passwordParameter(&quot;password&quot;) // default is password
//	 * 				.loginPage(&quot;/authentication/login&quot;) // default is /login with an HTTP get
//	 * 				.failureUrl(&quot;/authentication/login?failed&quot;) // default is /login?error
//	 * 				.loginProcessingUrl(&quot;/authentication/login/process&quot;)

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/cart").permitAll()
                .antMatchers("/store").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/checkout").permitAll()
                .antMatchers("/successpage").permitAll()
                .antMatchers("/account").permitAll()
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .failureUrl("/failedlogin")
                .loginProcessingUrl("/account")
                .and()
                .logout()
                .logoutUrl("/custom-logout")
                .deleteCookies("username")
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/successlogout")
                .and()
                .csrf().disable();
    }

    //cart tylko dla userow ale to nie dziala wiec ebac


}
