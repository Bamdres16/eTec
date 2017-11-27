package com.tec.resources;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.tec.messages.RecursosMensajes;
import com.tec.register.RegisterResource;

public class Application extends ResourceConfig {
	public Application() {
		register(RegisterResource.class);
		register(JacksonFeatures.class);
		register(RecursosMensajes.class);
	}
}
