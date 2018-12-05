package com.middleware.app.cow.repository;


import java.util.List;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface CommentRepository {

    @SelectProvider(type = SelectSqlBuilder.class, method = "build")
    @Results({
            @Result(property = "item", column = "item_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById")),
            @Result(property = "customer", column = "customer_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById"))
    })
    List<Comment> findAll(String table, String conditions, String orderByColumn, RowBounds rowBounds) throws Exception;

    @Select("select count(*) from comment")
    Long count() throws Exception;

    @Select("select * from comment c where c.id = #{id}")
    @Results({
            @Result(property = "item", column = "item_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById")),
            @Result(property = "customer", column = "customer_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById"))
    })
    Comment findById(Long id) throws Exception;

    @Insert("insert into comment(name, description, score, customer_id, item_id) values " +
            "(#{comment.name}, #{comment.description}, #{comment.score}, #{comment.customer.id}, #{comment.item.id})")
    void insert(@Param("comment") Comment comment) throws Exception;

    @Update("update comment set approved = #{comment.approved}, denounced = #{comment.denounced} where id = #{comment.id}")
    void update(@Param("comment") Comment comment) throws Exception;

    @Update("update comment set deleted = 1 where id = #{id}")
    void delete(Long id) throws Exception;

}