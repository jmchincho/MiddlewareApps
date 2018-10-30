package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Country;
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
@FixMethodOrder(MethodSorters.JVM)
public class CountryRepositoryTestIT {

    @Autowired
    public CountryRepository countryRepository;

    @Mock
    private Country country;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllCountry() throws Exception {
        Page<Country> result = countryRepository.findAll(null);

        assertThat(result.size(), equalTo(2));
        assertTrue(result.getResult().stream().anyMatch(country -> country.getName().equals("España")));
    }

    @Test
    public void findShouldReturnCountryByFilterCountry() throws Exception {
        when(country.getState()).thenReturn("disabled");

        Page<Country> result = countryRepository.findAll(country);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(country -> country.getName().equals("Francia")));
    }

    @Test
    public void getShouldReturnCountryById1() throws Exception {
        Country result = countryRepository.findById(1L);

        assertNotNull(result);
        assertEquals(result.getName(), "España");
    }

    @Test
    public void createAllShouldInsertNewCountry() throws Exception {
        when(country.getState()).thenReturn("enabled");
        when(country.getName()).thenReturn("Portugal");

        countryRepository.insert(country);

        Country result = countryRepository.findById(3L);

        assertNotNull(result);
        assertEquals(result.getName(), "Portugal");
        assertEquals(result.getState(), "enabled");
    }

    @Test
    public void updateAllShouldUpdateCountryById() throws Exception {
        Country update = countryRepository.findById(3L);
        update.setName("Marruecos");

        countryRepository.update(update);

        Country result = countryRepository.findById(3L);

        assertNotNull(result);
        assertEquals(result.getName(), "Marruecos");
        assertEquals(result.getState(), "enabled");
    }

    @Test
    public void deleteShouldRemoveCountryById() throws Exception {
        countryRepository.delete(2L);

        Country result = countryRepository.findById(2L);

        assertTrue(result.isDeleted());
    }
}