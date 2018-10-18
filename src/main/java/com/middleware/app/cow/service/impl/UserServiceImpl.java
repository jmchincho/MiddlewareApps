package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Page<User> find(Integer index, Integer totalCount,User user) throws CowException {
        return null;
    }

    @Override
    public User get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(User user) throws CowException {

    }

    @Override
    public void update(User user) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
