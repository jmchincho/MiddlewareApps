package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.AddressRepository;
import com.middleware.app.cow.service.AddressService;
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
    public Page<Address> find(Integer index, Integer totalCount, Address address) throws CowException {
        try {
            PageHelper.startPage(index, totalCount);
            return addressRepository.findAll(address);
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
