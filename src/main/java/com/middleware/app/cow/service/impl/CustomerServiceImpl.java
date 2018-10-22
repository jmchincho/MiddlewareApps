package com.middleware.app.cow.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.CustomerRepository;
import com.middleware.app.cow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> find(Integer index, Integer totalCount,Customer customer) throws CowException {
        try {
            PageHelper.offsetPage(index, totalCount);
            return customerRepository.findAll(customer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Customer get(Long id) throws CowException {
        try {
            return customerRepository.findById(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public Long create(Customer customer) throws CowException {
        try {
            customerRepository.insert(customer);

            return customerRepository.countAll();
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void update(Customer customer) throws CowException {
        try {
            customerRepository.update(customer);
        } catch (Exception e) {
            throw new CowException();
        }
    }

    @Override
    public void delete(Long id) throws CowException {
        try {
            customerRepository.delete(id);
        } catch (Exception e) {
            throw new CowException();
        }
    }
}
