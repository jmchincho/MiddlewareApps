package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CompanyRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })
    List<Company> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select c.id, c.name, c.logo, c.cif, c.url, c.urlState, c.telephone, u.id as user_id from company c, user u where c.id = #{id} and u.company_id = c.id")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })
    Company findById(@Param("id") Long id) throws Exception;

    @Insert("insert into company(name, logo, cif, url, urlState, telephone) " +
            "values (#{company.name}, #{company.logo}, #{company.cif}, #{company.url}, #{company.urlState}, #{company.telephone})")
    int insert(@Param("company") Company company) throws Exception;

    @Update("update company set name = #{company.name}, logo = #{company.logo}, " +
            "cif = #{company.cif}, url = #{company.url}, urlState = #{company.urlState}, telephone = #{company.telephone} "+
            "where id = #{company.id}")
    void update(@Param("company") Company company) throws Exception;

    @Update("update user set deleted = 1 where company_id = #{id}")
    void delete(@Param("id") Long id) throws Exception;

    @Select("select count(*) from company")
    long countAll();

}