package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.domain.Variant;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VariantRepository {

    @Select({"<script>",
            "select * from variant v",
            "<where>",
            "<if test='variant != null'>",
            "<if test='variant.item != null'>",
            " and v.item_id=#{variant.item.id}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    @Results({
            @Result(property = "item", column = "item_id", javaType = Item.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById"))
    })
    Page<Variant> findAll(@Param("variant") Variant Variant) throws Exception;

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