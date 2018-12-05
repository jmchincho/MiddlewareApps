package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Item;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemEndpoint {

    @Autowired
    private ItemService itemService;

    public ItemEndpoint(ItemService itemService) {
        this.itemService = itemService;
    }

    @GET
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("per_page") Integer perPage,
                            @QueryParam("where") String where, @QueryParam("order_by") String orderBy) {
        try {
            return Response.ok().entity(itemService.find(page, perPage, where, orderBy)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/countAll")
    public Response countAll() {
        try {
            return Response.ok().entity(itemService.countAll()).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(itemService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Item item) {
        try {
            itemService.create(item);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Item item) {
        try {
            itemService.update(item);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            itemService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

}
