package pl.sda.wsumiedrogo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.MyUserPrincipal;
import pl.sda.wsumiedrogo.model.Roles;
import pl.sda.wsumiedrogo.model.User;
import pl.sda.wsumiedrogo.model.dto.UserDto;
import pl.sda.wsumiedrogo.repositories.UserRepository;
import pl.sda.wsumiedrogo.service.ResourceNotFoundException;
import pl.sda.wsumiedrogo.service.UserService;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto userDto = userService.getUserByEmail(email);

        //TODO: Zmiana na USERDTO powoduje, że model userdetails z MyUserprincipal się sypie
        // gdyż potrzebuje Usera a nie useraDto nie wiem czy Userdto w tamtym miejscu to dobry pomysł
        MyUserPrincipal myUserPrincipal = new MyUserPrincipal(userDto);


//        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                authorities(Arrays.stream(Roles.values()).collect(Collectors.toSet())));



        return myUserPrincipal;
    }

    Set<GrantedAuthority> authorities(Set<Roles> userRole){
        return userRole.stream()
                .map(roles -> new SimpleGrantedAuthority(Roles.ROLE_USER.toString()))
                .collect(Collectors.toSet());
    }

}
