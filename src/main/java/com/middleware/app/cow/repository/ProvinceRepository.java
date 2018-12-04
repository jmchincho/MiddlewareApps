package com.middleware.app.cow.repository;

import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ProvinceRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    /*@Results({
            @Result(property = "country", column = "country_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CountryRepository.findById"))
    })*/
    List<Province> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select * from province p where p.id = #{id}")
    /*@Results({
            @Result(property = "country", column = "country_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CountryRepository.findById"))
    })*/
    Province findById(Long id) throws Exception;

    @Insert("insert into province(name, state ,country_id) values "
            + "(#{province.name}, #{province.state} ,#{province.country.id})")
    void insert(@Param("province") Province province) throws Exception;

    @Update("update province set name = #{province.name}, state = #{province.state}, " +
            "country_id = #{province.country.id}"
            + "where id = #{province.id}")
    void update(@Param("province") Province province) throws Exception;

    @Update("update province set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}