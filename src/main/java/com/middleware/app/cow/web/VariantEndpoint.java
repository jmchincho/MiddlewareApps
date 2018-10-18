package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Variant;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/variant")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VariantEndpoint {

    @GET
    public Response findAll(Integer index, Integer totalCount) {
        return null;
    }

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, Variant variant) {
        return null;
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        return null;
    }

    @POST
    public Response post(Variant variant) {
        return null;
    }

    @PUT
    public Response put(Variant variant) {
        return null;
    }

    @DELETE
    public Response delete(Long id) {
        return null;
    }

}
