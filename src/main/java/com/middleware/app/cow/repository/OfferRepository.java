package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface OfferRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "item", column = "item_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById"))
    })
    List<Offer> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select * from offer o where o.id = #{id}")
    @Results({
            @Result(property = "item", column = "item_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById"))
    })
    Offer findById(Long id) throws Exception;

    @Insert("insert into offer(state, paymentType, price, startDate, finishDate, publishDate, item_id) values "
            + "(#{offer.state}, #{offer.paymentType}, #{offer.price}, " +
            "#{offer.startDate}, #{offer.finishDate}, #{offer.publishDate}, #{offer.item.id})")
    void insert(@Param("offer") Offer offer) throws Exception;

    @Update("update offer set state = #{offer.state}, paymentType = #{offer.paymentType}, price = #{offer.price}, " +
            "startDate = #{offer.startDate}, finishDate = #{offer.finishDate}, publishDate = #{offer.publishDate}, item_id = #{offer.item.id} " +
            "where id = #{offer.id}")
    void update(@Param("offer") Offer offer) throws Exception;

    @Update("update offer set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}