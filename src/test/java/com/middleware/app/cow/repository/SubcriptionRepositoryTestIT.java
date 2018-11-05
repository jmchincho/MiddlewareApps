package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.domain.Subcription;
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
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubcriptionRepositoryTestIT {

    @Autowired
    public SubcriptionRepository subcriptionRepository;

    @Mock
    private Subcription subcription;

    @Mock
    private Customer customer;

    @Mock
    private Company company;

    @Before
    public void setUp() throws Exception {
        when(customer.getId()).thenReturn(1L);

        when(company.getId()).thenReturn(1L);
    }

    @Test
    public void findShouldReturnAllSubcription() throws Exception {
        Page<Subcription> result = subcriptionRepository.findAll(subcription);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(subcription -> subcription.getCompany().getId().equals(company.getId())));
        assertTrue(result.getResult().stream().anyMatch(subcription -> subcription.getCustomer().getId().equals(customer.getId())));
    }

    @Test
    public void findShouldReturnSubcriptionByFilterSubcriptionAndCompanyId() throws Exception {
        when(subcription.getCompany()).thenReturn(company);

        Page<Subcription> result = subcriptionRepository.findAll(subcription);

        assertThat(result.size(), equalTo(2));
        assertTrue(result.getResult().stream().anyMatch(subcription -> subcription.getCompany().getId().equals(company.getId())));
        assertTrue(result.getResult().stream().anyMatch(subcription -> subcription.getCustomer().getId().equals(customer.getId())));
    }

    @Test
    public void getShouldReturnSubcriptionById1() throws Exception {
        Subcription result = subcriptionRepository.findById(1L);

        assertNotNull(result);
        assertTrue(result.getCompany().getId().equals(company.getId()));
        assertTrue(result.getCustomer().getId().equals(customer.getId()));
        assertTrue(result.getId().equals(1L));
    }

    @Test
    public void createAllShouldInsertNewSubcription() throws Exception {
        when(customer.getId()).thenReturn(2L);

        when(subcription.getCompany()).thenReturn(company);
        when(subcription.getCustomer()).thenReturn(customer);

        subcriptionRepository.insert(subcription);

        Subcription result = subcriptionRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getCompany().getId().equals(company.getId()));
        assertTrue(result.getCustomer().getId().equals(customer.getId()));
        assertTrue(result.getId().equals(3L));
    }

    @Test
    public void updateAllShouldUpdateSubcriptionById() throws Exception {
        when(company.getId()).thenReturn(2L);

        Subcription update = subcriptionRepository.findById(3L);

        update.setCompany(company);

        subcriptionRepository.update(update);

        Subcription result = subcriptionRepository.findById(3L);

        assertNotNull(result);
        assertTrue(result.getCompany().getId().equals(2L));
        assertTrue(result.getCustomer().getId().equals(2L));
        assertTrue(result.getId().equals(3L));
    }

    @Test
    public void deleteShouldRemoveSubcriptionById() throws Exception {
        subcriptionRepository.delete(1L);

        Subcription subcriptionDelete = subcriptionRepository.findById(1L);

        assertTrue(subcriptionDelete.isDeleted());
    }
}