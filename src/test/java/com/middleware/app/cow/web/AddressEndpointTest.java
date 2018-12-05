package com.middleware.app.cow.web;

import java.util.List;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Address;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.AddressService;
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
public class AddressEndpointTest {

    @Mock
    private AddressService addressService;

    private AddressEndpoint addressEndpoint;

    @Mock
    private List<Address> addresses;

    @Mock
    private Address address;

    @Before
    public void setUp() throws Exception {
        when(addressService.find(anyInt(), anyInt(), anyString(), anyString())).thenReturn(addresses);

        when(addressService.countAll()).thenReturn(2L);

        when(addressService.get(any())).thenReturn(address);

        addressEndpoint = new AddressEndpoint(addressService);
    }

    @Test
    public void findAllShouldCallServiceFindAllAndReturnResult() {
        Response result = addressEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAllAndReturnException() throws CowException {
        when(addressService.find(anyInt(), anyInt(), anyString(), anyString())).thenThrow(new CowException());

        Response result = addressEndpoint.findAll(anyInt(), anyInt(), anyString(), anyString());
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnResult() {
        Response result = addressEndpoint.countAll();

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void countAllShouldCallServiceCountAndReturnException() throws CowException {
        when(addressService.countAll()).thenThrow(new CowException());

        Response result = addressEndpoint.countAll();
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceGetAndReturnResult() {
        Response result = addressEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceGetAndReturnException() throws CowException {
        when(addressService.get(any())).thenThrow(new CowException());

        Response result = addressEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServicePostAndReturnResult() throws CowException {
        Response result = addressEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(addressService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServicePostAndReturnException() throws CowException {
        doThrow(new CowException()).when(addressService).create(any());

        Response result = addressEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServicePutAndReturnResult() throws CowException {
        Response result = addressEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(addressService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServicePutAndReturnException() throws CowException {
        doThrow(new CowException()).when(addressService).update(any());

        Response result = addressEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceDeleteAndReturnResult() throws CowException {
        Response result = addressEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(addressService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceDeleteAndReturnException() throws CowException {
        doThrow(new CowException()).when(addressService).delete(any());

        Response result = addressEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}