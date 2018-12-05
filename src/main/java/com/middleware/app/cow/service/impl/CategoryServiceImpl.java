package com.middleware.app.cow.service.impl;

import java.util.List;

import com.middleware.app.cow.domain.Category;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CategoryRepository;
import com.middleware.app.cow.service.CategoryService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Category.class.getSimpleName());

            return categoryRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
    }

    @Override
    public Category get(Long id) throws CowException {
        try {
            return categoryRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Category category) throws CowException {
        try {
            categoryRepository.insert(category);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Category category) throws CowException {
        try {
            categoryRepository.update(category);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            categoryRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
