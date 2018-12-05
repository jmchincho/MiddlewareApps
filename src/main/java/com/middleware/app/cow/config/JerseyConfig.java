package com.middleware.app.cow.config;

import com.middleware.app.cow.web.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CORSResponseFilter.class);
		register(AddressEndpoint.class);
		register(AdministratorEndpoint.class);
		register(BannerAdsEndpoint.class);
		register(CategoryEndpoint.class);
		register(CommentEndpoint.class);
		register(CompanyEndpoint.class);
		register(CountryEndpoint.class);
		register(CustomerEndpoint.class);
		register(ItemEndpoint.class);
		register(LocationEndpoint.class);
		register(OfferEndpoint.class);
		register(OrderEndpoint.class);
		register(OrderDetailEndpoint.class);
		register(ProvinceEndpoint.class);
		register(SubcategoryEndpoint.class);
		register(SubcriptionEndpoint.class);
		register(UserEndpoint.class);
		register(VariantEndpoint.class);
	}
}