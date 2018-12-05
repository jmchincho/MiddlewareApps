package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.Comment;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CommentRepository;
import com.middleware.app.cow.service.CommentService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Comment.class.getSimpleName());

            return commentRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
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
