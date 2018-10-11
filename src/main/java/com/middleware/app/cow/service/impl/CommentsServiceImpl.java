package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Comments;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CommentsService;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Override
    public Page<Comments> find(Comments comments) throws CowException {
        return null;
    }

    @Override
    public Comments get(Long id) throws CowException {
        return null;
    }

    @Override
    public void create(Comments comments) throws CowException {

    }

    @Override
    public void update(Comments comments) throws CowException {

    }

    @Override
    public void delete(Comments comments) throws CowException {

    }
}
