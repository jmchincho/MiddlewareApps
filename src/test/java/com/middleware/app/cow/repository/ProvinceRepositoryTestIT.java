package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.domain.Province;
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

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Province.class.getSimpleName());

        List<Province> result = provinceRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(province -> province.getName().equals("Sevilla")));
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