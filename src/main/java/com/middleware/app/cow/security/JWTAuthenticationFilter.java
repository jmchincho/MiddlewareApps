package com.middleware.app.cow.security;
import static com.middleware.app.cow.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.middleware.app.cow.security.Constants.ISSUER_INFO;
import static com.middleware.app.cow.security.Constants.SUPER_SECRET_KEY;
import static com.middleware.app.cow.security.Constants.TOKEN_BEARER_PREFIX;
import static com.middleware.app.cow.security.Constants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
                .setSubject(username)
                //.claim("name", name(username))
                .claim("roles", ((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getAuthorities())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
        response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
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

