package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubcategoryRepository {

    @Select({"<script>",
            "select * from subcategory sc",
            "<where>",
            "<if test='subcategory != null'>",
            "<if test='subcategory.state != null'>",
            " and sc.state=#{subcategory.state}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    @Results({
            @Result(property = "category", column = "category_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CategoryRepository.findById"))
    })
    Page<Subcategory> findAll(@Param("subcategory") Subcategory subcategory) throws Exception;

    @Select("select * from subcategory sc where sc.id = #{id}")
    @Results({
            @Result(property = "category", column = "category_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CategoryRepository.findById"))
    })
    Subcategory findById(@Param("id") Long id) throws Exception;

    @Insert("insert into subcategory(deleted, name, state ,sequence, category_id) values "
            + "(#{subcategory.deleted}, #{subcategory.name}, #{subcategory.state}, #{subcategory.sequence}, #{subcategory.category.id})")
    void insert(@Param("subcategory") Subcategory subcategory) throws Exception;

    @Update("update subcategory set deleted = #{subcategory.deleted}, name = #{subcategory.name}, state = #{subcategory.state}, " +
            "sequence = #{subcategory.sequence}, category_id = #{subcategory.category.id} where id = #{subcategory.id}")
    void update(@Param("subcategory") Subcategory subcategory) throws Exception;

    @Update("update subcategory set deleted = 1 where id = #{id}")
    void delete(@Param("id") Long id) throws Exception;

    @Select("select * from subcategory sc where sc.category_id = #{category_id}")
    List<Subcategory> findAllSubcategoriesByCategories(@Param("category_id") Long id) throws Exception;
    
}