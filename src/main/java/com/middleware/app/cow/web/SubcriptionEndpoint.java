package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Subcription;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.SubcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/subcription")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubcriptionEndpoint {

    @Autowired
    private SubcriptionService subcriptionService;

    public SubcriptionEndpoint(SubcriptionService subcriptionService) {
        this.subcriptionService = subcriptionService;
    }

    @GET
    public Response findAll(Integer index, Integer totalCount) {
        try {
            return Response.ok().entity(subcriptionService.find(index, totalCount, null)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, Subcription subcription) {
        try {
            return Response.ok().entity(subcriptionService.find(index, totalCount, subcription)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(subcriptionService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Subcription subcription) {
        try {
            subcriptionService.create(subcription);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Subcription subcription) {
        try {
            subcriptionService.update(subcription);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            subcriptionService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

}
