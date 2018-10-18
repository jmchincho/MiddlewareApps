package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    Page<User> findAll(User User) throws Exception;

    User findById(Long id) throws Exception;

    void insert(User User) throws Exception;

    void update(User User) throws Exception;

    void delete(Long id) throws Exception;
    
}