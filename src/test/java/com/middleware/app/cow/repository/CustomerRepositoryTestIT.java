package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Customer;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.JVM)
public class CustomerRepositoryTestIT {

    @Autowired
    public CustomerRepository customerRepository;

    @Mock
    private Customer customer;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllCustomerByUser() throws Exception {
        Page<Customer> result = customerRepository.findAll(null);

        assertThat(result.size(), equalTo(2));
        assertTrue(result.getResult().stream().anyMatch(customer -> customer.getName().equals("nameCustomer1")));
        assertTrue(result.getResult().stream().anyMatch(customer -> customer.getUser().getUsername().equals("customer1")));
    }

    @Test
    public void findShouldReturnCustomerByFilterCustomerAndUser() throws Exception {
        when(customer.getName()).thenReturn("nameCustomer1");

        Page<Customer> result = customerRepository.findAll(customer);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(customer -> customer.getName().equals("nameCustomer1")));
        assertTrue(result.getResult().stream().anyMatch(customer -> customer.getUser().getUsername().equals("customer1")));
    }

    @Test
    public void countAllShouldReturn2() {
        assertThat(customerRepository.countAll(), equalTo(2L));
    }

    @Test
    public void getShouldReturnCustomerById2() throws Exception {
        Customer customer2 = customerRepository.findById(2L);

        assertTrue(customer2.getName().equals("nameCustomer2"));
        assertTrue(customer2.getId().equals(2L));
    }

    @Test
    public void createAllShouldInsertNewCustomer() throws Exception {
        when(customer.getName()).thenReturn("Jose Manuel");
        when(customer.getSurname()).thenReturn("Chincho");
        when(customer.getDni()).thenReturn("47474747D");
        when(customer.getTelephone()).thenReturn(650650650);

        customerRepository.insert(customer);

        Long result = customerRepository.countAll();

        assertTrue(result.equals(3L));
    }

    @Test
    public void updateAllShouldUpdateCustomerById() throws Exception {
        Customer customerUpdate = customerRepository.findById(2L);
        customerUpdate.setSurname("Chincho Cardosa");

        customerRepository.update(customerUpdate);

        Customer updateCustomer = customerRepository.findById(2L);

        assertTrue(updateCustomer.getName().equals("nameCustomer2"));
        assertTrue(updateCustomer.getSurname().equals("Chincho Cardosa"));
    }

    @Test
    public void deleteShouldRemoveCustomerById() throws Exception {
        customerRepository.delete(2L);

        Customer customerDelete = customerRepository.findById(2L);

        assertTrue(customerDelete.getUser().isDeleted());
    }
}