package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.ProvinceRepository;
import com.middleware.app.cow.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Page<Province> find(Integer index, Integer totalCount,Province province) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);

            return provinceRepository.findAll(province);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Province get(Long id) throws CowException {
        try {
            return provinceRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Province province) throws CowException {
        try {
            provinceRepository.insert(province);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Province province) throws CowException {
        try {
            provinceRepository.update(province);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            provinceRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
