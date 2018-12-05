package com.middleware.app.cow.service.impl;

import java.util.List;

import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.AddressRepository;
import com.middleware.app.cow.service.AddressService;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddressServiceImpl implements AddressService {

    @Autowired
    public AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> find(Integer page, Integer perPage, String where, String orderBy) throws CowException {
        try {
            RowBounds rowBounds = new RowBounds(page, perPage);

            String table = SelectSqlBuilder.nameTable(Address.class.getSimpleName());

            return addressRepository.findAll(table, where, orderBy, rowBounds);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long countAll() throws CowException {
        try {
            return addressRepository.count();
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Address get(Long id) throws CowException {
        try {
            return addressRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void create(Address address) throws CowException {
        try {
            addressRepository.insert(address);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Address address) throws CowException {
        try {
            addressRepository.update(address);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            addressRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
