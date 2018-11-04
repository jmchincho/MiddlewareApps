package com.middleware.app.cow.repository;


import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentRepository {

    @Select({"<script>",
            "select * from comment c",
            "<where>",
            "<if test='comment != null'>",
            "<if test='comment.item != null'>",
            " and c.item_id=#{comment.item.id}",
            "</if>",
            "</if>",
            "</where>",
            "</script>"})
    @Results({
            @Result(property = "item", column = "item_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.ItemRepository.findById")),
            @Result(property = "customer", column = "customer_id", javaType = User.class,  one = @One(select = "com.middleware.app.cow.repository.CustomerRepository.findById"))
    })
    Page<Comment> findAll(@Param("comment") Comment comment) throws Exception;

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