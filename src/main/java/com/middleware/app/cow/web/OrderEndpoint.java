package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Order;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderEndpoint {

    @Autowired
    private OrderService orderService;

    public OrderEndpoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    public Response findAll(Integer index, Integer totalCount) {
        try {
            return Response.ok().entity(orderService.find(index,totalCount,null)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, Order order) {
        try {
            return Response.ok().entity(orderService.find(index, totalCount, order)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(orderService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Order order) {
        try {
            orderService.create(order);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Order order) {
        try {
            orderService.update(order);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            orderService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

}
