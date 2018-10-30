package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LocationRepository {

    @Select({"<script>",
            "select * from location l",
            "<where>",
            "<if test='location != null'>",
            "<if test='location.name != null'>",
            " and l.name=#{location.name}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    /*@Results({
            @Result(property = "province", column = "province_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ProvinceRepository.findById"))
    })*/
    Page<Location> findAll(@Param("location") Location location) throws Exception;

    @Select("select * from location l where l.id = #{id}")
    /*@Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById"))
    })*/
    Location findById(Long id) throws Exception;

    @Insert("insert into location(name, state, province_id) values "
            + "(#{location.name}, #{location.state}, #{location.province.id})")
    void insert(@Param("location") Location location) throws Exception;

    @Update("update location set name = #{location.name} ,state = #{location.state} ,province_id = #{location.province.id} "
            + "where id = #{location.id}")
    void update(@Param("location") Location location) throws Exception;

    @Update("update location set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}