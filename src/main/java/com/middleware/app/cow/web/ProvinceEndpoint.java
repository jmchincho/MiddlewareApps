package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Province;
import com.middleware.app.cow.exceptions.CowException;
import com.middleware.app.cow.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/province")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProvinceEndpoint {

    @Autowired
    private ProvinceService provinceService;

    public ProvinceEndpoint(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GET
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("per_page") Integer perPage,
                            @QueryParam("where") String where, @QueryParam("order_by") String orderBy) {
        try {
            return Response.ok().entity(provinceService.find(page, perPage, where, orderBy)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/countAll")
    public Response countAll() {
        try {
            return Response.ok().entity(provinceService.countAll()).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        try {
            return Response.ok().entity(provinceService.get(id)).build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @POST
    public Response post(Province province) {
        try {
            provinceService.create(province);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @PUT
    public Response put(Province province) {
        try {
            provinceService.update(province);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    public Response delete(Long id) {
        try {
            provinceService.delete(id);
            return Response.ok().build();
        } catch (CowException e) {
            return Response.serverError().build();
        }
    }

}
