package com.middleware.app.cow.repository;

import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface VariantRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "item", column = "item_id", javaType = Item.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById"))
    })
    List<Variant> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select * from variant v where v.id = #{id}")
    @Results({
            @Result(property = "item", column = "item_id", javaType = Item.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById"))
    })
    Variant findById(Long id) throws Exception;

    @Insert("insert into variant(type, size, color, state, stock, price, startDate, finishDate, publishDate, item_id) values "
            + "(#{variant.type}, #{variant.size}, #{variant.color}, #{variant.state}, #{variant.stock}, #{variant.price}, " +
            "#{variant.startDate}, #{variant.finishDate}, #{variant.publishDate}, #{variant.item.id})")
    void insert(@Param("variant") Variant Variant) throws Exception;

    @Update("update variant set type = #{variant.type}, size = #{variant.size}, color = #{variant.color}, state = #{variant.state}, stock = #{variant.stock}, price = #{variant.price}, " +
            "startDate = #{variant.startDate}, finishDate = #{variant.finishDate}, publishDate = #{variant.publishDate}, item_id = #{variant.item.id} "
            + "where id = #{variant.id}")
    void update(@Param("variant") Variant Variant) throws Exception;

    @Update("update variant set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;
}