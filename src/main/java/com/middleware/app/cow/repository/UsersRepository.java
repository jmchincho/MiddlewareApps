package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersRepository {

    Page<Users> findAll(Users users);

    Users findById(Long id);

    void insert(Users users);

    void update(Users users);

    void delete(Long id);
    
}