package com.middleware.app.cow.repository;

import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface OrderRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "address", column = "address_id", javaType = Address.class,  one = @One(select = "com.middleware.app.cow.repository.AddressRepository.findById"))
    })
    List<Order> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select count(*) from purchaseOrder")
    Long count() throws Exception;

    @Select("select * from purchaseOrder o where o.id = #{id}")
    @Results({
            @Result(property = "address", column = "address_id", javaType = Address.class,  one = @One(select = "com.middleware.app.cow.repository.AddressRepository.findById"))
    })
    Order findById(Long id) throws Exception;

    @Insert("insert into purchaseOrder(paymentType, paidOrder, observations, state, priceTotal, address_id) values "
            + "(#{order.paymentType}, #{order.paidOrder}, #{order.observations} " +
            ",#{order.state} ,#{order.priceTotal},#{order.address.id})")
    void insert(@Param("order") Order order) throws Exception;

    @Update("update purchaseOrder set paymentType = #{order.paymentType}, paidOrder = #{order.paidOrder}, observations = #{order.observations}, " +
            "priceTotal = #{order.priceTotal} ,address_id = #{order.address.id}"
            + "where id = #{order.id}")
    void update(@Param("order") Order order) throws Exception;

    @Update("update purchaseOrder set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}