package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.Subcategory;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.SubcategoryService;
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
public class SubcategoryEndpointTest {

    @Mock
    private SubcategoryService subcategoryService;

    @Mock
    private Response response;

    @Mock
    private Page<Subcategory> page;

    private SubcategoryEndpoint subcategoryEndpoint;

    @Mock
    private List<Subcategory> subcategories;

    @Mock
    private Subcategory subcategory;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(subcategories);
        when(subcategoryService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(subcategoryService.get(any())).thenReturn(subcategory);

        subcategoryEndpoint = new SubcategoryEndpoint(subcategoryService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = subcategoryEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(subcategoryService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = subcategoryEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = subcategoryEndpoint.findAllByFilter(1, 5, subcategory);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(subcategoryService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = subcategoryEndpoint.findAllByFilter(1, 5, subcategory);

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = subcategoryEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(subcategoryService.get(any())).thenThrow(new CowException());

        Response result = subcategoryEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = subcategoryEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(subcategoryService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(subcategoryService).create(any());

        Response result = subcategoryEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = subcategoryEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(subcategoryService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(subcategoryService).update(any());

        Response result = subcategoryEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = subcategoryEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(subcategoryService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(subcategoryService).delete(any());

        Response result = subcategoryEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}