package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.domain.Comments;
import com.middleware.app.cow.exceptions.CowException;
import org.springframework.stereotype.Service;

@Service
public interface CommentsService {

    Page<Comments> find(Comments comments) throws CowException;

    Comments get(Long id) throws CowException;

    void create(Comments comments) throws CowException;

    void update(Comments comments) throws CowException;

    void delete(Comments comments) throws CowException;

}
