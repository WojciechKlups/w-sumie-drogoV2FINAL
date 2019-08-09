package pl.sda.wsumiedrogo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.wsumiedrogo.model.Account;
import pl.sda.wsumiedrogo.model.Roles;
import pl.sda.wsumiedrogo.repositories.AccountRepository;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

//        Poprzednia implementacja
//        User user = userRepository.findByEmail(email).orElseThrow(ResourceNotFoundException::new);

        Account account = accountRepository.findByUsername(email);

        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + email + " was not found in the database");
        }

        String role = account.getUserRole();

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        GrantedAuthority authority = new SimpleGrantedAuthority(role);

        grantedAuthorityList.add(authority);

        boolean enabled = account.isActive();
        boolean accountNonExpired = true;
        boolean creditialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = new User(account.getUsername(),
                account.getEncryptedPassword(), enabled, accountNonExpired,
                creditialsNonExpired, accountNonLocked, grantedAuthorityList);

        //Poprzednia implementacja
//        MyUserPrincipal myUserPrincipal = new MyUserPrincipal(user);


//        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                authorities(Arrays.stream(Roles.values()).collect(Collectors.toSet())));



        return userDetails;
    }

}
