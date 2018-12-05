package com.middleware.app.cow.service.impl;

import java.util.List;

import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.VariantRepository;
import com.middleware.app.cow.service.VariantService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    public VariantServiceImpl(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    @Override
    public List<Variant> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Variant.class.getSimpleName());

            return variantRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        try {
            return variantRepository.count();
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Variant get(Long id) throws CowException {
        try {
            return variantRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Variant variant) throws CowException {
        try {
            variantRepository.insert(variant);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Variant variant) throws CowException {
        try {
            variantRepository.update(variant);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            variantRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
