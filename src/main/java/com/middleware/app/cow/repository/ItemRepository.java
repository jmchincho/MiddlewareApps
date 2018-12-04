package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface ItemRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "company", column = "company_id", javaType = Company.class,  one = @One(select = "com.middleware.app.cow.repository.CompanyRepository.findById")),
            @Result(property = "subcategory", column = "subcategory_id", javaType = Subcategory.class,  one = @One(select = "com.middleware.app.cow.repository.SubcategoryRepository.findById"))
    })
    List<Item> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select * from item i where i.id = #{id}")
    @Results({
            @Result(property = "company", column = "company_id", javaType = Company.class,  one = @One(select = "com.middleware.app.cow.repository.CompanyRepository.findById")),
            @Result(property = "subcategory", column = "subcategory_id", javaType = Subcategory.class,  one = @One(select = "com.middleware.app.cow.repository.SubcategoryRepository.findById"))
    })
    Item findById(Long id) throws Exception;

    @Insert("insert into item(name, descriptions, url, image1, image2, image3, image4, image5, startDate, finishDate, publishDate, " +
            "conditions, sendType, state, type, price, sendPrice, stock, company_id, subcategory_id) values "
            + "(#{item.name}, #{item.descriptions}, #{item.url}, #{item.image1}, #{item.image2}, #{item.image3}, #{item.image4}, #{item.image5}, #{item.startDate}" +
            ",#{item.finishDate} ,#{item.publishDate},#{item.conditions} ,#{item.sendType}, #{item.state}, #{item.type}, #{item.price}, #{item.sendPrice}, #{item.stock}, " +
            "#{item.company.id}, #{item.subcategory.id})")
    void insert(@Param("item") Item item) throws Exception;

    @Update("update item set name = #{item.name}, descriptions = #{item.descriptions}, url = #{item.url}, image1 = #{item.image1}, image2 = #{item.image2}, image3 = #{item.image3}, " +
            "image4 = #{item.image4} ,image5 = #{item.image5} ,startDate = #{item.startDate} ,finishDate = #{item.finishDate}, publishDate = #{item.publishDate}, conditions = #{item.conditions}, " +
            "sendType = #{item.sendType}, state = #{item.state}, type = #{item.type}, sendPrice = #{item.sendPrice}, stock = #{item.stock}, company_id = #{item.company.id}, " +
            "subcategory_id = #{item.subcategory.id}" +
            "where id = #{item.id}")
    void update(@Param("item") Item item) throws Exception;

    @Update("update item set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}