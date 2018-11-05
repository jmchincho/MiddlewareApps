package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.domain.Province;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProvinceRepositoryTestIT {

    @Autowired
    public ProvinceRepository provinceRepository;

    @Mock
    private Province province;

    @Mock
    private Country country;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findShouldReturnAllProvinceByUser() throws Exception {
        Page<Province> result = provinceRepository.findAll(null);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(province -> province.getName().equals("Sevilla")));
    }

    @Test
    public void findShouldReturnProvinceByFilterProvinceAndUser() throws Exception {
        when(province.getName()).thenReturn("Sevilla");

        Page<Province> result = provinceRepository.findAll(province);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(province -> province.getName().equals("Sevilla")));
    }

    @Test
    public void getShouldReturnProvinceById1() throws Exception {
        Province result = provinceRepository.findById(2L);

        assertNotNull(result);
        assertThat(result.getName(), equalTo("Madrid"));
    }

    @Test
    public void createAllShouldInsertNewProvince() throws Exception {
        when(province.getCountry()).thenReturn(country);
        when(province.getCountry().getId()).thenReturn(1L);
        when(province.getName()).thenReturn("Galicia");
        when(province.getState()).thenReturn("enabled");

        provinceRepository.insert(province);

        Province result = provinceRepository.findById(3L);

        assertNotNull(result);
        assertThat(result.getName(), equalTo("Galicia"));
        //assertThat(result.getCountry().getId(), equalTo(1L));
        assertThat(result.getState(), equalTo("enabled"));
    }

    @Test
    public void updateAllShouldUpdateProvinceById() throws Exception {
        when(province.getId()).thenReturn(3L);
        when(province.getName()).thenReturn("Bilbao");
        when(province.getCountry()).thenReturn(country);
        when(province.getCountry().getId()).thenReturn(1L);
        when(province.getState()).thenReturn("enabled");

        provinceRepository.update(province);

        Province result = provinceRepository.findById(3L);

        assertNotNull(result);
        assertThat(result.getName(), equalTo("Bilbao"));
        //assertThat(result.getCountry().getId(), equalTo(1L));
        assertThat(result.getState(), equalTo("enabled"));
    }

    @Test
    public void deleteShouldRemoveProvinceById() throws Exception {
        provinceRepository.delete(2L);

        Province result = provinceRepository.findById(2L);

        assertTrue(result.isDeleted());
    }
}