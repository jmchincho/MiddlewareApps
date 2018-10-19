package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {

    Page<User> findAll(User User) throws Exception;

    @Select("select * from user u where u.id = #{id}")
    User findById(@Param("user_id") Long id) throws Exception;

    void insert(User User) throws Exception;

    void update(User User) throws Exception;

    void delete(Long id) throws Exception;
    
}