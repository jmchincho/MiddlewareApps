package com.middleware.app.cow.service.impl;

import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CompanyRepository;
import com.middleware.app.cow.service.CompanyService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Company.class.getSimpleName());

            return companyRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        try {
            return companyRepository.count();
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
