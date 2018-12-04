package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    List<User> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    User get(Long id) throws CowException;

    User findByUsername(String username) throws CowException;

    void create(User user) throws CowException;

    void update(User user) throws CowException;

    void delete(Long id) throws CowException;

}
