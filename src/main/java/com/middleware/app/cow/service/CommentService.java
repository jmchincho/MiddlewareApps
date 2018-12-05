package com.middleware.app.cow.service;

import java.util.List;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    List<Comment> find(Integer page, Integer perPage, String where, String orderBy) throws CowException;

    Long countAll() throws CowException;

    Comment get(Long id) throws CowException;

    void create(Comment comment) throws CowException;

    void update(Comment comment) throws CowException;

    void delete(Long id) throws CowException;

}
