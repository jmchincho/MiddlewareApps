package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Page<Comment> find(Integer index, Integer totalCount,Comment comment) throws CowException {
        return null;
    }

    @Override
    public Comment get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Comment comment) throws CowException {

    }

    @Override
    public void update(Comment comment) throws CowException {

    }

    @Override
    public void delete(Long id) throws CowException {

    }
}
