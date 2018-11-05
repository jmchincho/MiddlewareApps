package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AddressRepository {

    @Select({"<script>",
            "select * from address a",
            "<where>",
            "<if test='address != null'>",
            "<if test='address.street != null'>",
            " and a.street=#{address.street}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById")),
            @Result(property = "location", column = "location_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.LocationRepository.findById"))
    })
    Page<Address> findAll(@Param("address") Address address) throws Exception;

    @Select("select * from address a where a.id = #{id}")
    @Results({
            @Result(property = "user", column = "user_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.UserRepository.findById")),
            @Result(property = "location", column = "location_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.LocationRepository.findById"))
    })
    Address findById(@Param("id") Long id) throws Exception;

    @Insert("insert into address(deleted, street, postalCode ,number ,floor ,stairs, location_id, user_id) values "
            + "(#{address.deleted}, #{address.street}, #{address.postalCode} " +
                ",#{address.number} ,#{address.floor},#{address.stairs}, #{address.location.id}, #{address.user.id})")
    void insert(@Param("address")Address address) throws Exception;

    @Update("update address set deleted = #{address.deleted}, street = #{address.street}, postalCode = #{address.postalCode}, " +
            "number = #{address.number} ,floor = #{address.floor} ,stairs = #{address.stairs}, location_id = #{address.location.id}, user_id = #{address.user.id} "
            + "where id = #{address.id}")
    void update(@Param("address") Address address) throws Exception;

    @Update("update address set deleted = 1 where id = #{id}")
    void delete(@Param("id") Long id) throws Exception;

}