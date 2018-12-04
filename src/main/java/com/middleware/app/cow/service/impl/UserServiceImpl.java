package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.UserRepository;
import com.middleware.app.cow.service.UserService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_COMPANY = "ROLE_COMPANY";
    public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(User.class.getSimpleName());

            List<User> users = userRepository.findAll(table, where, orderBy, rowBounds);
            users.forEach(user -> user.setPassword(null));

            return users;
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public User get(Long id) throws CowException {
        try {
            return userRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public User findByUsername(String username) throws CowException {
        try {
            User user = userRepository.findByUsername(username);
            user.setPassword(null);

            return user;
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);

            if(user == null){
                throw new UsernameNotFoundException("Invalid username or password.");
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    @Override
    public void create(User user) throws CowException {
        try {
            userRepository.insert(user);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(User user) throws CowException {
        try {
            userRepository.update(user);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            userRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    private List<SimpleGrantedAuthority> getAuthority(User user) {
        String role = user.getAdministrator() != null ? ROLE_ADMIN : user.getCompany() != null ? ROLE_COMPANY : ROLE_CUSTOMER;

        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
