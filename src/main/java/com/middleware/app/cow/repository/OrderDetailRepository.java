package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.domain.OrderDetail;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface OrderDetailRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "item", column = "item_id", javaType = Item.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById")),
            @Result(property = "order", column = "order_id", javaType = Order.class,  one = @One(select = "com.middleware.app.cow.repository.OrderRepository.findById"))
    })
    List<OrderDetail> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select * from orderDetail od where od.id = #{id}")
    @Results({
            @Result(property = "item", column = "item_id", javaType = Item.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById")),
            @Result(property = "order", column = "order_id", javaType = Order.class,  one = @One(select = "com.middleware.app.cow.repository.OrderRepository.findById"))
    })
    OrderDetail findById(Long id) throws Exception;

    @Insert("insert into orderDetail(quantity, sendState, price, order_id, item_id) values "
            + "(#{orderDetail.quantity}, #{orderDetail.sendState}, #{orderDetail.price}, #{orderDetail.order.id}, #{orderDetail.item.id})")
    void insert(@Param("orderDetail") OrderDetail orderDetail) throws Exception;

    @Update("update orderDetail set quantity = #{orderDetail.quantity}, sendState = #{orderDetail.sendState}, price = #{orderDetail.price}, sendDate = #{orderDetail.sendDate}, " +
            "deliveredDate = #{orderDetail.deliveredDate}, cancelledDate = #{orderDetail.cancelledDate}, order_id = #{orderDetail.order.id}, item_id = #{orderDetail.item.id} " +
            "where id = #{orderDetail.id}")
    void update(@Param("orderDetail") OrderDetail orderDetail) throws Exception;

    @Update("update orderDetail set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}