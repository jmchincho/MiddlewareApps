package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserRepository {

    @Select({"<script>",
            "select * from user u where deleted = 0",
            "<if test='user != null'>",
                "<if test='user.username != null'>",
                    " and u.username=#{user.username}",
                "</if>",
                "<if test='user.mail != null'>",
                    " and u.mail=#{user.mail}",
                "</if>",
                "<if test='user.state != null'>",
                    " and u.state=#{user.state}",
                "</if>",
            "</if>",
            "</script>"})
    /*@Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })*/
    Page<User> findAll(@Param("user") User user) throws Exception;

    @Select("select * from user u where u.id = #{id}")
    User findById(@Param("id") Long id) throws Exception;
    
    @Insert("insert into user(deleted, username, password ,mail ,state) values "
            + "(#{user.deleted}, #{user.username}, #{user.password} " +
            ",#{user.mail} ,#{user.state})")
    void insert(@Param("user") User user) throws Exception;

    @Update("update user set deleted = #{user.deleted}, username = #{user.username}, password = #{user.password}, " +
            "mail = #{user.mail} ,state = #{user.state}"
            + "where id = #{user.id}")
    void update(@Param("user") User user) throws Exception;

    @Update("update user set deleted = 1 where id = #{id}")
    void delete(@Param("id")Long id) throws Exception;
    
}