package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CommentRepository;
import com.middleware.app.cow.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<Comment> find(Integer index, Integer totalCount,Comment comment) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return commentRepository.findAll(comment);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Comment get(Long id) throws CowException {
        try {
            return commentRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Comment comment) throws CowException {
        try {
            commentRepository.insert(comment);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Comment comment) throws CowException {
        try {
            commentRepository.update(comment);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            commentRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
