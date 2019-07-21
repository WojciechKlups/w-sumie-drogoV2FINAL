/*
 * Written by Wojciech Klupś
 * Copyright (c) 2019. All rights reserved
 */

package pl.sda.wsumiedrogo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private boolean isLoggedIn = false;

    @Column(unique = true)
    private Long phoneNumber;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Cart cart;


}
