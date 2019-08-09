package pl.sda.wsumiedrogo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        permitAllAccess(http);

        adminAndUserAccess(http);

        adminAccess(http);

        http.authorizeRequests().and()
                .exceptionHandling()
                .accessDeniedPage("/403");

        loginAndLogoutHandler(http);

    }

    private void loginAndLogoutHandler(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/failedlogin")
                .loginProcessingUrl("/account")
                .and()
                .logout()
                .logoutUrl("/custom-logout")
                .deleteCookies("username")
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/successlogout");
    }

    private void adminAndUserAccess(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/orderList", "/admin/order", "/admin/accountInfo")//
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
    }

    private void permitAllAccess(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**","/login","/cart","/store","/register",
                        "/checkout","/successpage","/account").permitAll();
    }

    private void adminAccess(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/product")
                .access("hasRole('ROLE_ADMIN')");
    }

}
