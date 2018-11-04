package com.middleware.app.cow.security;

import com.middleware.app.cow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String ROLE = "ROLE_";
    public static final String CUSTOMER = "CUSTOMER";
    public static final String COMPANY = "COMPANY";
    public static final String ADMIN = "ADMIN";

    @Autowired
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.middleware.app.cow.domain.User userLogin = new com.middleware.app.cow.domain.User();
        userLogin.setUsername(username);

        com.middleware.app.cow.domain.User user = null;
        try {
            user = userRepository.findAll(userLogin).get(0);
        } catch (Exception e) {
            throw new UsernameNotFoundException(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set getAuthority(com.middleware.app.cow.domain.User user) {
        String role;

        Set authorities = new HashSet();

        if(user.getCustomer() != null) {
            role = CUSTOMER;
        } else if (user.getCompany() != null){
            role = COMPANY;
        } else {
            role = ADMIN;
        }

        authorities.add(new SimpleGrantedAuthority(ROLE + role));

        return authorities;
    }
}
