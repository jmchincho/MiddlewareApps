package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.VariantRepository;
import com.middleware.app.cow.service.VariantService;
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
    public Page<Variant> find(Integer index, Integer totalCount,Variant variant) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return variantRepository.findAll(variant);
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
