package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "subcategories", column = "id", javaType = List.class,  many = @Many(fetchType = FetchType.DEFAULT, select = "com.middleware.app.cow.repository.SubcategoryRepository.findAllSubcategoriesByCategories"))
    })
    List<Category> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select count(*) from category")
    Long count() throws Exception;

    @Select("select * from category c where c.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "subcategories", column = "id", javaType = List.class,  many = @Many(fetchType = FetchType.DEFAULT, select = "com.middleware.app.cow.repository.SubcategoryRepository.findAllSubcategoriesByCategories"))
    })
    Category findById(@Param("id") Long id) throws Exception;

    @Insert("insert into category(deleted, name, state ,sequence) values "
            + "(#{category.deleted}, #{category.name}, #{category.state} ,#{category.sequence})")
    void insert(@Param("category") Category category) throws Exception;

    @Update("update category set deleted = #{category.deleted}, name = #{category.name}, state = #{category.state}, " +
            "sequence = #{category.sequence} where id = #{category.id}")
    void update(@Param("category") Category category) throws Exception;

    @Update("update category set deleted = 1 where id = #{id}")
    void delete(@Param("id") Long id) throws Exception;

}