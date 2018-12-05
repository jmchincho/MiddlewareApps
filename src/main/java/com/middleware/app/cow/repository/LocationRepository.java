package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface LocationRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    /*@Results({
            @Result(property = "province", column = "province_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ProvinceRepository.findById"))
    })*/
    List<Location> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    Long count() throws Exception;

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