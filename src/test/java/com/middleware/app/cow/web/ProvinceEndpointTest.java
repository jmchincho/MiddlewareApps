package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ProvinceService;
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
public class ProvinceEndpointTest {

    @Mock
    private ProvinceService provinceService;

    @Mock
    private Response response;

    @Mock
    private Page<Province> page;

    private ProvinceEndpoint provinceEndpoint;

    @Mock
    private List<Province> provinces;

    @Mock
    private Province province;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(provinces);
        when(provinceService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(provinceService.get(any())).thenReturn(province);

        provinceEndpoint = new ProvinceEndpoint(provinceService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = provinceEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(provinceService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = provinceEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = provinceEndpoint.findAllByFilter(1, 5, province);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(provinceService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = provinceEndpoint.findAllByFilter(1, 5, province);

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = provinceEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(provinceService.get(any())).thenThrow(new CowException());

        Response result = provinceEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = provinceEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(provinceService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(provinceService).create(any());

        Response result = provinceEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = provinceEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(provinceService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(provinceService).update(any());

        Response result = provinceEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = provinceEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(provinceService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(provinceService).delete(any());

        Response result = provinceEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}