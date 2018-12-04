package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.SubcriptionRepository;
import com.middleware.app.cow.service.SubcriptionService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcriptionServiceImpl implements SubcriptionService {

    @Autowired
    private SubcriptionRepository subcriptionRepository;

    public SubcriptionServiceImpl(SubcriptionRepository subcriptionRepository) {
        this.subcriptionRepository = subcriptionRepository;
    }

    @Override
    public List<Subcription> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Subcription.class.getSimpleName());

            return subcriptionRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Subcription get(Long id) throws CowException {
        try {
            return subcriptionRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Subcription subcription) throws CowException {
        try {
            subcriptionRepository.insert(subcription);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Subcription subcription) throws CowException {
        try {
            subcriptionRepository.update(subcription);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            subcriptionRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
