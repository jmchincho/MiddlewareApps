package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Page<User> find(Integer index, Integer totalCount,User user) throws CowException;

    User get(Long id) throws CowException;

    void create(User user) throws CowException;

    void update(User user) throws CowException;

    void delete(Long id) throws CowException;

}
