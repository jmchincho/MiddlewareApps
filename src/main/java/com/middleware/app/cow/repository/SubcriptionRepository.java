package com.middleware.app.cow.repository;

import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface SubcriptionRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "customer", column = "customer_id", javaType = Customer.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById")),
            @Result(property = "company", column = "company_id", javaType = Company.class,  one = @One(select = "com.middleware.app.cow.repository.CompanyRepository.findById"))
    })
    List<Subcription> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    Long count() throws Exception;

    @Select("select * from subcription s where s.id = #{id}")
    @Results({
            @Result(property = "customer", column = "customer_id", javaType = Customer.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById")),
            @Result(property = "company", column = "company_id", javaType = Company.class,  one = @One(select = "com.middleware.app.cow.repository.CompanyRepository.findById"))
    })
    Subcription findById(Long id) throws Exception;

    @Insert("insert into subcription(customer_id, company_id) values (#{subcription.customer.id}, #{subcription.company.id})")
    void insert(@Param("subcription") Subcription subcription) throws Exception;

    @Update("update subcription set customer_id = #{subcription.customer.id}, company_id = #{subcription.company.id} where id = #{subcription.id}")
    void update(@Param("subcription") Subcription subcription) throws Exception;

    @Update("update subcription set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;
    
}