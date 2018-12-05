package com.middleware.app.cow.repository;

import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Location;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationRepositoryTestIT {

    @Autowired
    public LocationRepository locationRepository;

    @Mock
    private Location location;

    @Mock
    private Province province;

    @Mock
    private ProvinceRepository provinceRepository;

    @Before
    public void setUp() throws Exception {
        when(province.getId()).thenReturn(1L);

        when(provinceRepository.findById(any())).thenReturn(province);

        when(location.getProvince()).thenReturn(province);
    }

    @Test
    public void findShouldReturnAllLocationByUser() throws Exception {
        String where = "address.street='Calle Jerico'";
        String orderBy = "address.street";

        RowBounds rowBound = new RowBounds(0, 5);

        String table = SelectSqlBuilder.nameTable(Location.class.getSimpleName());

        List<Location> result = locationRepository.findAll(table, null, null, rowBound);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.stream().anyMatch(location -> location.getName().equals("Utrera")));
    }

    @Test
    public void countShouldReturnCountAll() throws Exception {
        Long result = locationRepository.count();

        assertNotNull(result);
    }

    @Test
    public void getShouldReturnLocationById1() throws Exception {
        Location result = locationRepository.findById(2L);

        assertNotNull(result);
        assertThat(result.getName(), equalTo("Madrid"));
    }

    @Test
    public void createAllShouldInsertNewLocation() throws Exception {
        when(location.getProvince()).thenReturn(province);
        when(location.getProvince().getId()).thenReturn(1L);
        when(location.getName()).thenReturn("Sevilla");
        when(location.getState()).thenReturn("enabled");

        locationRepository.insert(location);

        Location result = locationRepository.findById(3L);

        assertNotNull(result);
        assertThat(result.getName(), equalTo("Sevilla"));
        //assertThat(result.getProvince().getId(), equalTo(1L));
        assertThat(result.getState(), equalTo("enabled"));
    }

    @Test
    public void updateAllShouldUpdateLocationById() throws Exception {
        when(location.getProvince()).thenReturn(province);
        when(location.getProvince().getId()).thenReturn(1L);

        Location update = locationRepository.findById(3L);
        update.setName("Dos Hermanas");
        update.setProvince(province);

        locationRepository.update(update);

        Location result = locationRepository.findById(3L);

        assertNotNull(result);
        assertThat(result.getName(), equalTo("Dos Hermanas"));
        //assertThat(result.getProvince().getId(), equalTo(1L));
        assertThat(result.getState(), equalTo("enabled"));
    }

    @Test
    public void deleteShouldRemoveLocationById() throws Exception {
        locationRepository.delete(2L);

        Location result = locationRepository.findById(2L);

        assertTrue(result.isDeleted());
    }
}