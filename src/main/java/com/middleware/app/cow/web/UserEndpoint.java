package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.User;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserEndpoint {

    @Autowired
    private UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAll(Integer index, Integer totalCount) {
        try {
            return Response.ok().entity(userService.find(index, totalCount, null)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, User user) {
        try {
            return Response.ok().entity(userService.find(index, totalCount, user)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(userService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(User user) {
        try {
            userService.create(user);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(User user) {
        try {
            userService.update(user);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            userService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }
}
