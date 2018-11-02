package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.SubcriptionRepository;
import com.middleware.app.cow.service.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcriptionServiceImpl implements SubcriptionService {

    @Autowired
    private SubcriptionRepository subcriptionRepository;

    public SubcriptionServiceImpl(SubcriptionRepository subcriptionRepository) {
        this.subcriptionRepository = subcriptionRepository;
    }

    @Override
    public Page<Subcription> find(Integer index, Integer totalCount,Subcription subcription) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return subcriptionRepository.findAll(subcription);
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
