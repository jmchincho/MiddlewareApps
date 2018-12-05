package com.middleware.app.cow.web;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Administrator;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.AdministratorService;
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
public class AdministratorEndpointTest {

    @Mock
    private AdministratorService administratorService;

    private AdministratorEndpoint administratorEndpoint;

    @Mock
    private List<Administrator> administrators;

    @Mock
    private Administrator administrator;

    @Before
    public void setUp() throws Exception {
        when(administratorService.find(anyInt(), anyInt(), anyString(), anyString())).thenReturn(administrators);

        when(administratorService.countAll()).thenReturn(2L);

        when(administratorService.get(any())).thenReturn(administrator);

        administratorEndpoint = new AdministratorEndpoint(administratorService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = administratorEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(administratorService.find(anyInt(), anyInt(), anyString(), anyString())).thenThrow(new CowException());

        Response result = administratorEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnResult() {
        Response result = administratorEndpoint.countAll();

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnException() throws CowException {
        when(administratorService.countAll()).thenThrow(new CowException());

        Response result = administratorEndpoint.countAll();
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = administratorEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(administratorService.get(any())).thenThrow(new CowException());

        Response result = administratorEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = administratorEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(administratorService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(administratorService).create(any());

        Response result = administratorEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = administratorEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(administratorService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(administratorService).update(any());

        Response result = administratorEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = administratorEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(administratorService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(administratorService).delete(any());

        Response result = administratorEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}