package com.middleware.app.cow.service;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.repository.LocationRepository;
import com.middleware.app.cow.service.impl.LocationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class LocationServiceTest {

	private LocationService locationService;

	@Mock
	private LocationRepository locationRepository;

	@Mock
	private List<Location> locations;

	@Mock
	private Location location;

	@Mock
	private Page<Location> page;

	@Before
	public void setUp() throws Exception {
		when(page.getResult()).thenReturn(locations);

		when(locationRepository.findAll(any())).thenReturn(page);

		when(locationRepository.findById(anyLong())).thenReturn(location);

		locationService = new LocationServiceImpl(locationRepository);
	}

	@Test
	public void findShouldCallRepositoryFindAndReturnResult() throws CowException {
		Page<Location> result = locationService.find(1,1, any(Location.class));

		assertNotNull(result.getResult());
	}

	@Test(expected = CowException.class)
	public void findShouldCallRepositoryFindAndReturnException() throws Exception {
		when(locationRepository.findAll(any())).thenThrow(new Exception());

		locationService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void getShouldCallRepositoryFindAndReturnResult() throws CowException {
		Location result = locationService.get(anyLong());

		assertNotNull(result);
	}

	@Test(expected = CowException.class)
	public void getShouldCallRepositoryFindAndReturnException() throws Exception {
		when(locationRepository.findAll(any())).thenThrow(new Exception());

		locationService.find(anyInt(), anyInt(), any());
	}

	@Test
	public void createAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		locationService.create(location);

		verify(locationRepository, times(1)).insert(location);
	}

	@Test(expected = CowException.class)
	public void createAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(locationRepository).insert(any());

		locationService.create(any());
	}

	@Test
	public void updateAllShouldCallRepositoryFindAndReturnResult() throws Exception {
		locationService.update(location);

		verify(locationRepository, times(1)).update(location);
	}

	@Test(expected = CowException.class)
	public void updateAllShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(locationRepository).update(any());

		locationService.update(any());
	}

	@Test
	public void deleteShouldCallRepositoryFindAndReturnResult() throws Exception {
		locationService.delete(1L);

		verify(locationRepository, times(1)).delete(anyLong());
	}

	@Test(expected = CowException.class)
	public void deleteShouldCallRepositoryFindAndReturnException() throws Exception {
		doThrow(new CowException()).when(locationRepository).delete(any());

		locationService.delete(any());
	}

}