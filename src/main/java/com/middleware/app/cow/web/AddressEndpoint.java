package com.middleware.app.cow.web;

import com.middleware.app.cow.domain.Address;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressEndpoint {

	@GET
    public Response findAll(Integer index, Integer totalCount) {
	    return null;
}

    @GET
    public Response findAllByFilter(Integer index, Integer totalCount, Address address) {
        return null;
    }

    @GET
    @Path("/{id}")
    public Response get(@PathVariable Long id) {
        return null;
    }

    @POST
    public Response post(Address address) {
        return null;
    }

    @PUT
    public Response put(Address address) {
        return null;
    }

    @DELETE
    public Response delete(Long id) {
        return null;
    }

}
