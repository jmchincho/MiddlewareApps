package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CustomerRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })
    List<Customer> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    Long count() throws Exception;

    @Select("select c.id, c.name, c.surname, c.dni, c.telephone, u.id as user_id from customer c, user u where c.id = #{id} and u.customer_id = c.id")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })
    Customer findById(@Param("id") Long id) throws Exception;

    @Insert("insert into customer(name, surname, dni, telephone) " +
            "values (#{customer.name}, #{customer.surname}, #{customer.dni}, #{customer.telephone})")
    int insert(@Param("customer") Customer customer) throws Exception;

    @Update("update customer set name = #{customer.name}, surname = #{customer.surname}, " +
            "dni = #{customer.dni}, telephone = #{customer.telephone} where id = #{customer.id}")
    void update(@Param("customer") Customer customer) throws Exception;

    @Update("update user set deleted = 1 where customer_id = #{id}")
    void delete(@Param("id") Long id) throws Exception;

    @Select("select count(*) from customer")
    long countAll();

}