package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.SubcriptionService;
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
public class SubcriptionEndpointTest {

    @Mock
    private SubcriptionService subcriptionService;

    @Mock
    private Response response;

    @Mock
    private Page<Subcription> page;

    private SubcriptionEndpoint subcriptionEndpoint;

    @Mock
    private List<Subcription> subcriptiones;

    @Mock
    private Subcription subcription;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(subcriptiones);
        when(subcriptionService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(subcriptionService.get(any())).thenReturn(subcription);

        subcriptionEndpoint = new SubcriptionEndpoint(subcriptionService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = subcriptionEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(subcriptionService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = subcriptionEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = subcriptionEndpoint.findAllByFilter(1, 5, subcription);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(subcriptionService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = subcriptionEndpoint.findAllByFilter(1, 5, subcription);

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = subcriptionEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(subcriptionService.get(any())).thenThrow(new CowException());

        Response result = subcriptionEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = subcriptionEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(subcriptionService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(subcriptionService).create(any());

        Response result = subcriptionEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = subcriptionEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(subcriptionService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(subcriptionService).update(any());

        Response result = subcriptionEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = subcriptionEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(subcriptionService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(subcriptionService).delete(any());

        Response result = subcriptionEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}