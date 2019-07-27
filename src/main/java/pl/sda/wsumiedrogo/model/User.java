/*
 * Written by Wojciech Klupś
 * Copyright (c) 2019. All rights reserved
 */

package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @NotEmpty
    private String postalCode;
    @NotNull
    @NotEmpty
    private String city;


    private String image = "../img/user.png";

    private boolean isLoggedIn = false;

    @Column(unique = true)
    private Long phoneNumber;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotNull
    @NotEmpty
    private String password;

    private String activationCode;
    private boolean activated;

    private Roles role = Roles.ROLE_USER;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Cart cart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
