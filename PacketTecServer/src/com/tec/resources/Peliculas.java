package com.tec.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.tec.dto.Estudiante;

@Path("/estudiantes")
public class Peliculas {

	private static List<Estudiante> data = new ArrayList<>(); 
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response createEstudiante(Estudiante estudiante) {
		data.add(estudiante);
		return Response.ok()
				.build();
	}
	
	@GET
	@Produces("application/json")
	public Response getEstudiantes() {
		try {
			return Response.ok()
					.entity(data)
					.build();
		} catch (Exception ex) {
			return Response.serverError()
					.entity(ex.getMessage())
					.build();
		}
		
	}
}
