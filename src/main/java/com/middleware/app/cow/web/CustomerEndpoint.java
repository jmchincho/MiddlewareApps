package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Customer;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerEndpoint {

    @Autowired
    private CustomerService customerService;

    public CustomerEndpoint(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    public Response findAll(Integer index, Integer totalCount) {
        try {
            return Response.ok().entity(customerService.find(index, totalCount, null)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, Customer customer) {
        try {
            return Response.ok().entity(customerService.find(index, totalCount, null)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(customerService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Customer customer) {
        try {
            return Response.ok().entity(customerService.create(customer)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Customer customer) {
        try {
            customerService.update(customer);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            customerService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }
}
