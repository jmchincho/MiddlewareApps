package com.middleware.app.cow.service.impl;

import java.util.List;

import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.AddressRepository;
import com.middleware.app.cow.repository.AdministratorRepository;
import com.middleware.app.cow.service.AdministratorService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public List<Administrator> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Administrator.class.getSimpleName());

            return administratorRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        return null;
    }

    @Override
    public Administrator get(Long id) throws CowException {
        try {
            return administratorRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long create(Administrator administrator) throws CowException {
        try {
            administratorRepository.insert(administrator);

            return administratorRepository.countAll();
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Administrator administrator) throws CowException {
        try {
            administratorRepository.update(administrator);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            administratorRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
