package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProvinceRepository {

    @Select({"<script>",
            "select * from province p",
            "<where>",
            "<if test='province != null'>",
            "<if test='province.name != null'>",
            " and p.name=#{province.name}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    /*@Results({
            @Result(property = "country", column = "country_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CountryRepository.findById"))
    })*/
    Page<Province> findAll(@Param("province") Province province) throws Exception;

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