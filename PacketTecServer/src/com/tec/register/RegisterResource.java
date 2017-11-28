package com.tec.register;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/register")
public class RegisterResource {
	private static  JSONArray data = new JSONArray(); 
	private static JSONObject results = new JSONObject();
	public RegisterResource() {
		// TODO Auto-generated constructor stub
		results.put("results",data);
		}
	@SuppressWarnings("unchecked")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response registrar(RegisterEntity registro) {
		JSONArray compare = (JSONArray) results.get("results");
		JSONObject reg = convertir(registro);
		if (compare.contains(reg)) {
			return Response.ok("Exist").build();
		}
		else {
			
			data.add(reg);
			results.put("results", data);
			return Response.ok("Sucess").build();
		}
	}
	@SuppressWarnings("unchecked")
	private JSONObject convertir (RegisterEntity registro) {
		JSONObject reg = new JSONObject();
		reg.put("name", registro.getName());
		reg.put("username", registro.getUsername());	
		reg.put("password", registro.getPassword());
		reg.put("email", registro.getEmail());
		return reg;
		
	}
	
	@GET
	@Produces("application/json")
	public JSONObject getRegistros() {
		
			return results;
		

	}
	
}
