package com.tec.messages;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;

@Path("/message")
public class RecursosMensajes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(UUID.randomUUID());
	}

	private static List<EntidadMensaje> data = new ArrayList<>();
	private static JSONObject results = new JSONObject();
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response sendMensage(EntidadMensaje mensaje) {
		mensaje.identificador(UUID.randomUUID().toString());
		data.add(mensaje);
		results.put("messages", data);
		return Response.ok("Success").build();

	}

	@GET
	@Produces("application/json")
	public Response getMessage() {
		try {
			return Response.ok().entity(results).build();
		} catch (Exception ex) {
			return Response.serverError().entity(ex.getMessage()).build();
		}
	}

	@GET
	@Produces("application/json")
	@Path("{num}")
	public Response getMessageID(@PathParam("num") int num) {
		try {
			return Response.ok().entity(results.get("messages")).build();
		} catch (Exception ex) {
			return Response.serverError().entity(ex.getMessage()).build();
		}
	}

}
