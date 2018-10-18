package com.middleware.app.cow.config;

import com.middleware.app.cow.web.AddressEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CORSResponseFilter.class);
		register(AddressEndpoint.class);
	}
}