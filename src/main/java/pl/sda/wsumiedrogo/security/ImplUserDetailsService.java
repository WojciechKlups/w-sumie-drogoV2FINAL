package pl.sda.wsumiedrogo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Roles;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.repositories.UserRepository;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImplUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public ImplUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities(Arrays.stream(Roles.values()).collect(Collectors.toSet())));

        return userDetails;
    }

    Set<GrantedAuthority> authorities(Set<Roles> userRole){
        return userRole.stream()
                .map(roles -> new SimpleGrantedAuthority(Roles.ROLE_USER.toString()))
                .collect(Collectors.toSet());
    }

}
