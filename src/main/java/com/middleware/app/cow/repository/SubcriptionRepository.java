package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SubcriptionRepository {

    @Select({"<script>",
            "select * from subcription s",
            "<where>",
            "<if test='subcription != null'>",
            "<if test='subcription.customer != null'>",
            " and s.customer_id=#{subcription.customer.id}",
            "</if>",
            "<if test='subcription.company != null'>",
            " and s.company_id=#{subcription.company.id}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    @Results({
            @Result(property = "customer", column = "customer_id", javaType = Customer.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById")),
            @Result(property = "company", column = "company_id", javaType = Company.class,  one = @One(select = "com.middleware.app.cow.repository.CompanyRepository.findById"))
    })
    Page<Subcription> findAll(@Param("subcription") Subcription subcription) throws Exception;

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