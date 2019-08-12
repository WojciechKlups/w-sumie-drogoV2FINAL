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

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//        Poprzednia implementacja
        User user = userRepository.findByEmail(email).orElseThrow(ResourceNotFoundException::new);

        CustomUserDetails customUserDetails = new CustomUserDetails(user);

//        if (account == null) {
//            throw new UsernameNotFoundException("User " //
//                    + email + " was not found in the database");
//        }

//        String role = account.getUserRole();
//
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//
//        GrantedAuthority authority = new SimpleGrantedAuthority(role);
//
//        grantedAuthorityList.add(authority);
//
//        boolean enabled = account.isActive();
//        boolean accountNonExpired = true;
//        boolean creditialsNonExpired = true;
//        boolean accountNonLocked = true;

        //Poprzednia implementacja
//        CustomUserDetails myUserPrincipal = new CustomUserDetails(user);


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
