package com.middleware.app.cow.web;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Country;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CountryService;
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
public class CountryEndpointTest {

    @Mock
    private CountryService countAllryService;

    private CountryEndpoint countAllryEndpoint;

    @Mock
    private List<Country> countAllries;

    @Mock
    private Country countAllry;

    @Before
    public void setUp() throws Exception {
        when(countAllryService.find(anyInt(), anyInt(), anyString(), anyString())).thenReturn(countAllries);

        when(countAllryService.countAll()).thenReturn(2L);

        when(countAllryService.get(any())).thenReturn(countAllry);

        countAllryEndpoint = new CountryEndpoint(countAllryService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = countAllryEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(countAllryService.find(anyInt(), anyInt(), anyString(), anyString())).thenThrow(new CowException());

        Response result = countAllryEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnResult() {
        Response result = countAllryEndpoint.countAll();

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnException() throws CowException {
        when(countAllryService.countAll()).thenThrow(new CowException());

        Response result = countAllryEndpoint.countAll();
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = countAllryEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(countAllryService.get(any())).thenThrow(new CowException());

        Response result = countAllryEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = countAllryEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(countAllryService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(countAllryService).create(any());

        Response result = countAllryEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = countAllryEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(countAllryService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(countAllryService).update(any());

        Response result = countAllryEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = countAllryEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(countAllryService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(countAllryService).delete(any());

        Response result = countAllryEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}