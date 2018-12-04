package com.middleware.app.cow.service.impl;

import java.util.List;

import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CountryRepository;
import com.middleware.app.cow.service.CountryService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
       try {
           RowBounds rowBounds = new RowBounds(page, perPage);

           String table = SelectSqlBuilder.nameTable(Country.class.getSimpleName());

           return countryRepository.findAll(table, where, orderBy, rowBounds);
       } catch (Exception e) {
           throw new CowException();
       }
    }

    @Override
    public Country get(Long id) throws CowException {
        try {
            return countryRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Country country) throws CowException {
        try {
            countryRepository.insert(country);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Country country) throws CowException {
        try {
            countryRepository.update(country);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            countryRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
