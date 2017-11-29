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

import com.tec.Interface.Observador;
import com.tec.Interface.ObservadorMensajes;
import com.tec.Interface.SujetoObservable;

@Path("/message")
public class RecursosMensajes implements SujetoObservable{
	private static List<EntidadMensaje> data = new ArrayList<>();
	private static JSONObject results = new JSONObject();
	private ArrayList<Observador> observadores;
	private ObservadorMensajes visor;
	
	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		for (Observador o : observadores) {
			o.update();
		}
	}
	public RecursosMensajes() {
		// TODO Auto-generated constructor stub
		observadores = new ArrayList<Observador>();
		visor = new ObservadorMensajes();
		enlazarobservador(visor);
		
	}
	public void enlazarobservador (Observador o) {
		observadores.add(o);
	}
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response sendMensage(EntidadMensaje mensaje) {
		mensaje.identificador(UUID.randomUUID().toString());
		data.add(mensaje);
		results.put("messages", data);
		notificar();
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
