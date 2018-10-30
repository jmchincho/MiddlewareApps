package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CountryRepository;
import com.middleware.app.cow.service.CountryService;
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
    public Page<Country> find(Integer index, Integer totalCount,Country country) throws CowException {
       try {
           PageHelper.offsetPage(index, totalCount);
           return countryRepository.findAll(country);
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
