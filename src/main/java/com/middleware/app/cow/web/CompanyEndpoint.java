package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Company;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyEndpoint {
    
    @Autowired
    private CompanyService companyService;

    public CompanyEndpoint(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GET
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("per_page") Integer perPage,
                            @QueryParam("where") String where, @QueryParam("order_by") String orderBy) {
        try {
            return Response.ok().entity(companyService.find(page, perPage, where, orderBy)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/countAll")
    public Response countAll() {
        try {
            return Response.ok().entity(companyService.countAll()).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(companyService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Company company) {
        try {
            return Response.ok().entity(companyService.create(company)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Company company) {
        try {
            companyService.update(company);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            companyService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

}
