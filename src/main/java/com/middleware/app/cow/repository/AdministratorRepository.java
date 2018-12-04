package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface AdministratorRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })
    List<Administrator> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select a.id, a.name, a.surname, u.id as user_id from administrator a, user u where a.id = #{id} and u.administrator_id = a.id")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })
    Administrator findById(@Param("id") Long id) throws Exception;

    @Insert("insert into administrator(name, surname) values (#{administrator.name}, #{administrator.surname})")
    int insert(@Param("administrator") Administrator administrator) throws Exception;

    @Update("update administrator set name = #{administrator.name}, surname = #{administrator.surname} where id = #{administrator.id}")
    void update(@Param("administrator") Administrator administrator) throws Exception;

    @Update("update user set deleted = 1 where administrator_id = #{id}")
    void delete(@Param("id") Long id) throws Exception;

    @Select("select count(*) from administrator")
    long countAll();

}