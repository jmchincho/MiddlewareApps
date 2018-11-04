package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Variant;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private VariantService variantService;

    public VariantEndpoint(VariantService variantService) {
        this.variantService = variantService;
    }

    @GET
    public Response findAll(Integer index, Integer totalCount) {
        try {
            return Response.ok().entity(variantService.find(index, totalCount, null)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, Variant variant) {
        try {
            return Response.ok().entity(variantService.find(index, totalCount, variant)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(variantService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Variant variant) {
        try {
            variantService.create(variant);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Variant variant) {
        try {
            variantService.update(variant);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            variantService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

}
