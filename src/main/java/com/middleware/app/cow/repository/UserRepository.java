package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "customer", column = "customer_id", javaType = Customer.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById")),
            @Result(property = "administrator", column = "administrator_id", javaType = Administrator.class,  one = @One(select = "com.middleware.app.cow.repository.AdministratorRepository.findById")),
            @Result(property = "company", column = "company_id", javaType = Company.class,  one = @One(select = "com.middleware.app.cow.repository.CompanyRepository.findById"))
    })
    List<User> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select * from user u where u.id = #{id}")
    User findById(@Param("id") Long id) throws Exception;

    @Select("select * from user u where u.username = #{username} or u.mail = #{username}")
    User findByUsername(@Param("username") String username) throws Exception;
    
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