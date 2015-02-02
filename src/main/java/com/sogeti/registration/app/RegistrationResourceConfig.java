package com.sogeti.registration.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resource")
public class RegistrationResourceConfig extends ResourceConfig {
	
	public RegistrationResourceConfig()
	{
		packages("com.sogeti.todo.resource");
		register(JacksonFeature.class);
		
	}

}
