package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Location;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.LocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(CowApplicationTests.class)
public class LocationEndpointTest {

    @Mock
    private LocationService locationService;

    @Mock
    private Response response;

    @Mock
    private Page<Location> page;

    private LocationEndpoint locationEndpoint;

    @Mock
    private List<Location> locations;

    @Mock
    private Location location;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(locations);
        when(locationService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(locationService.get(any())).thenReturn(location);

        locationEndpoint = new LocationEndpoint(locationService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = locationEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(locationService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = locationEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = locationEndpoint.findAllByFilter(1, 5, location);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(locationService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = locationEndpoint.findAllByFilter(1, 5, location);

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = locationEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(locationService.get(any())).thenThrow(new CowException());

        Response result = locationEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = locationEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(locationService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(locationService).create(any());

        Response result = locationEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = locationEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(locationService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(locationService).update(any());

        Response result = locationEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = locationEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(locationService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(locationService).delete(any());

        Response result = locationEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}