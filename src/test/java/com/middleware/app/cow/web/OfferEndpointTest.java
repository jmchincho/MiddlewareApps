package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Offer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OfferService;
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
public class OfferEndpointTest {

    @Mock
    private OfferService offerService;

    @Mock
    private Response response;

    @Mock
    private Page<Offer> page;

    private OfferEndpoint offerEndpoint;

    @Mock
    private List<Offer> offers;

    @Mock
    private Offer offer;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(offers);
        when(offerService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(offerService.get(any())).thenReturn(offer);

        offerEndpoint = new OfferEndpoint(offerService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = offerEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(offerService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = offerEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = offerEndpoint.findAllByFilter(1, 5, offer);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(offerService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = offerEndpoint.findAllByFilter(1, 5, offer);

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = offerEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(offerService.get(any())).thenThrow(new CowException());

        Response result = offerEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = offerEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(offerService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(offerService).create(any());

        Response result = offerEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = offerEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(offerService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(offerService).update(any());

        Response result = offerEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = offerEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(offerService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(offerService).delete(any());

        Response result = offerEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}