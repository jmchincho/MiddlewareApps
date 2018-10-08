package com.middleware.app.cow.web;

import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/instructors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressEndpoint {

	/*@Autowired
	private InstructorService instructorService;

	public CommentsEndpoint(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@GET
	public List<Instructor> getAllInstructor() {
		return instructorService.getAllInstructor();
	}*/
}
