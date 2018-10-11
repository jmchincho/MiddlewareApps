package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Users;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Override
    public Page<Users> find(Users users) throws CowException {
        return null;
    }

    @Override
    public Users get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Users users) throws CowException {

    }

    @Override
    public void update(Users users) throws CowException {

    }

    @Override
    public void delete(Users users) throws CowException {

    }
}
