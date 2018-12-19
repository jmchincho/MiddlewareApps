package com.middleware.app.cow.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static com.middleware.app.cow.security.Constants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            User credenciales = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String username = ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername();

        Collection authorities = ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getAuthorities();

        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
                .setSubject(username)
                //.claim("name", name(username))
                .claim(ROLES, authorities)
                .claim(REDIRECT, getRedirect(authorities))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
        response.addHeader(ACCESS_CONTROL_EXPOSE_HEADERS , HEADER_AUTHORIZACION_KEY);
        response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + token);
    }

    protected String getRedirect(Collection authorities) {
        return authorities.contains(new SimpleGrantedAuthority(ROLE_CUSTOMER)) ? CLIENTE : authorities.contains(new SimpleGrantedAuthority(ROLE_COMPANY)) ? EMPRESA : ADMINISTRADOR;
    }

    protected String name(String username) {
        User user = null;

        try {
            user = userService.findByUsername(username);
        } catch (CowException e) {
            e.printStackTrace();
        }

        String result = user.getCustomer() != null ? nameByUser(user.getCustomer()) : user.getCompany() != null ? nameByUser(user.getCompany()) : nameByUser(user.getAdministrator());

        return result;
    }

    private String nameByUser(Object object) {
        if(object instanceof Customer) {
            return ((Customer)object).getName() + " " + ((Customer)object).getSurname();
        } else if(object instanceof Company) {
            return ((Company)object).getName();
        } else {
            return ((Administrator)object).getName() + " " + ((Administrator)object).getSurname();
        }
    }
}

