package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Users;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {

    Page<Users> find(Users users) throws CowException;

    Users get(Long id) throws CowException;

    void create(Users users) throws CowException;

    void update(Users users) throws CowException;

    void delete(Users users) throws CowException;

}
