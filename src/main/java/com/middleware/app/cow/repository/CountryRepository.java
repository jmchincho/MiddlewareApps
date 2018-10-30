package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Country;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CountryRepository {

    @Select({"<script>",
            "select * from country c",
            "<where>",
            "<if test='country != null'>",
            "<if test='country.name != null'>",
            " and c.name=#{country.name}",
            "</if>",
            "<if test='country.state != null'>",
            " and c.state=#{country.state}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    /*@Results({
            @Result(property = "province", column = "province_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ProvinceRepository.findById"))
    })*/
    Page<Country> findAll(@Param("country") Country country) throws Exception;

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