package pl.sda.wsumiedrogo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/account").hasAnyRole("USER","ADMIN").anyRequest().authenticated();

        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll().anyRequest().permitAll();

        http.authorizeRequests().and()
                .exceptionHandling()
                .accessDeniedPage("/403");

        http.authorizeRequests()
                .and().formLogin().loginPage("/login").permitAll()
                .failureUrl("/failedlogin")
                .successHandler(myAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutUrl("/custom-logout")
                .deleteCookies("username")
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/successlogout");

    }


}
