package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    Page<Comment> find(Integer index, Integer totalCount,Comment comment) throws CowException;

    Comment get(Long id) throws CowException;

    void create(Comment comment) throws CowException;

    void update(Comment comment) throws CowException;

    void delete(Long id) throws CowException;

}
