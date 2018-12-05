package com.middleware.app.cow.service.impl;

import java.util.List;

import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.ProvinceRepository;
import com.middleware.app.cow.service.ProvinceService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
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
    public List<Province> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Province.class.getSimpleName());

            return provinceRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
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
