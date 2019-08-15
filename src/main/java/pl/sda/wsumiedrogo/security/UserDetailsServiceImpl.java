package pl.sda.wsumiedrogo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.CustomUserDetails;
import pl.sda.wsumiedrogo.model.Role;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.UserRepository;
import pl.sda.wsumiedrogo.service.ResourceNotFoundException;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


       User user = userRepository.findByEmail(email).orElseThrow(ResourceNotFoundException::new);

        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(Role.ROLE_USER.getRole())));
        return userDetails;
    }

//    private List<GrantedAuthority> resolveUserAuthorities(User user) {
//
//    }


}
