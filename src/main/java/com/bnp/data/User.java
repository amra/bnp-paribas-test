package com.bnp.data;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class User extends org.springframework.security.core.userdetails.User {

    private String username;

    private String password;

    private String street;

    private String houseNumber;

    private String city;

    private String state;

    User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
