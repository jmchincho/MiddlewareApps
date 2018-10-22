package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CompanyRepository;
import com.middleware.app.cow.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Page<Company> find(Integer index, Integer totalCount,Company company) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return companyRepository.findAll(company);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Company get(Long id) throws CowException {
        try {
            return companyRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long create(Company company) throws CowException {
        try {
            companyRepository.insert(company);

            return companyRepository.countAll();
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Company company) throws CowException {
        try {
            companyRepository.update(company);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            companyRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
