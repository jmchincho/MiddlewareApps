package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CountryRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    /*@Results({
            @Result(property = "province", column = "province_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ProvinceRepository.findById"))
    })*/
    List<Country> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select count(*) from country")
    Long count() throws Exception;

    @Select("select * from country c where c.id = #{id}")
    /*@Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })*/
    Country findById(Long id) throws Exception;

    @Insert("insert into country(name, state) values "
            + "(#{country.name}, #{country.state})")
    void insert(@Param("country") Country country) throws Exception;

    @Update("update country set name = #{country.name} ,state = #{country.state}"
            + "where id = #{country.id}")
    void update(@Param("country") Country country) throws Exception;

    @Update("update country set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}