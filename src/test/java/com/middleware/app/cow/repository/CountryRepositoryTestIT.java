package com.middleware.app.cow.repository;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.utils.SelectSqlBuilder;
import org.apache.ibatis.session.RowBounds;
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
        String where = "a.user.id=1";
        String orderBy = "a.street asc";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Country.class.getSimpleName());

        List<Country> result = countryRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(country -> country.getName().equals("España")));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = countryRepository.count();

        assertNotNull(result);
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