package com.middleware.app.cow.repository;


import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentRepository {

    Page<Comment> findAll(Comment comment) throws Exception;

    Comment findById(Long id) throws Exception;

    void insert(Comment comment) throws Exception;

    void update(Comment comment) throws Exception;

    void delete(Long id) throws Exception;

}