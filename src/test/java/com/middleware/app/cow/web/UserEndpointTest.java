package com.middleware.app.cow.web;

import com.github.pagehelper.Page;
import com.middleware.app.cow.CowApplicationTests;
import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.UserService;
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
public class UserEndpointTest {

    @Mock
    private UserService userService;

    @Mock
    private Response response;

    @Mock
    private Page<User> page;

    private UserEndpoint userEndpoint;

    @Mock
    private List<User> users;

    @Mock
    private User user;

    @Before
    public void setUp() throws Exception {
        when(response.getStatusInfo()).thenReturn(Response.Status.OK);

        when(page.getResult()).thenReturn(users);
        when(userService.find(anyInt(), anyInt(), any())).thenReturn(page);

        when(userService.get(any())).thenReturn(user);

        userEndpoint = new UserEndpoint(userService);
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnResult() {
        Response result = userEndpoint.findAll(1, 1);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllShouldCallServiceFindAndReturnException() throws CowException {
        when(userService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = userEndpoint.findAll(1, 5);
        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnResult() {
        Response result = userEndpoint.findAllByFilter(1, 5, user);

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void findAllByFilterShouldCallServiceFindAndReturnException() throws CowException {
        when(userService.find(anyInt(), anyInt(), any())).thenThrow(new CowException());

        Response result = userEndpoint.findAllByFilter(1, 5, user);

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void getShouldCallServiceFindAndReturnResult() {
        Response result = userEndpoint.get(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    public void getShouldCallServiceFindAndReturnException() throws CowException {
        when(userService.get(any())).thenThrow(new CowException());

        Response result = userEndpoint.get(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = userEndpoint.post(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(userService, times(1)).create(any());
    }

    @Test
    public void postAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(userService).create(any());

        Response result = userEndpoint.post(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = userEndpoint.put(any());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(userService, times(1)).update(any());
    }

    @Test
    public void putAllShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(userService).update(any());

        Response result = userEndpoint.put(any());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnResult() throws CowException {
        Response result = userEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.ok().build().getStatus());
        verify(userService, times(1)).delete(any());
    }

    @Test
    public void deleteShouldCallServiceFindAndReturnException() throws CowException {
        doThrow(new CowException()).when(userService).delete(any());

        Response result = userEndpoint.delete(anyLong());

        assertEquals(result.getStatus(), Response.serverError().build().getStatus());
    }
}