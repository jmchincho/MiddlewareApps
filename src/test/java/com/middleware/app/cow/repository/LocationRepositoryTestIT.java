package com.middleware.app.cow.repository;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.domain.Province;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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
        Page<Location> result = locationRepository.findAll(null);

        assertThat(result.size(), equalTo(3));
        assertTrue(result.getResult().stream().anyMatch(location -> location.getName().equals("Utrera")));
    }

    @Test
    public void findShouldReturnLocationByFilterLocation() throws Exception {
        when(location.getName()).thenReturn("Madrid");

        Page<Location> result = locationRepository.findAll(location);

        assertThat(result.size(), equalTo(1));
        assertTrue(result.getResult().stream().anyMatch(location -> location.getName().equals("Madrid")));
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