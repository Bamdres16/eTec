package com.tec.register;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Path("/register")
public class RegisterResource {
	private static JSONArray data = new JSONArray();
	private static JSONObject results = new JSONObject();

	@SuppressWarnings("unchecked")
	public RegisterResource() {
		// TODO Auto-generated constructor stub
		results.put("results", data);
	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response registrar(RegisterEntity registro) {

		if (validate(registro) == 1) {
			return Response.ok("User Exist").build();
		}
		if (validate(registro) == 2) {
			return Response.ok("Email Exist").build();
		} else {
			if (registro.getEmail().isEmpty() || registro.getName().isEmpty() || registro.getPassword().isEmpty()
					|| registro.getUsername().isEmpty() || registro.getUsername().length() < 4 || registro.getPassword().length() < 6) {
				return Response.ok("Complete all spaces").build();
			} 
			if (sonEspacios(registro.getEmail()) || sonEspacios(registro.getName()) ||

					sonEspacios(registro.getUsername()) || sonEspacios(registro.getPassword())) {

				return Response.ok("Complete all spaces").build();
			}
			else {
				data.add(convertir(registro)); 
				results.put("results", data);
				return Response.ok("Sucess").build();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private JSONObject convertir(RegisterEntity registro) {

		JSONObject reg = new JSONObject();
		reg.put("name", registro.getName());
		reg.put("password", registro.getPassword());
		reg.put("email", registro.getEmail());
		reg.put("username", registro.getUsername());
		return reg;

	}

	private int validate(RegisterEntity registerEntity) {
		JSONArray compare = (JSONArray) results.get("results");
		for (int i = 0; i < compare.size(); i++) {
			if (((JSONObject) compare.get(i)).get("username").equals(registerEntity.getUsername())) {
				return 1;
			}
			if (((JSONObject) compare.get(i)).get("email").equals(registerEntity.getEmail())) {
				return 2;
			}

		}

		return 0;
	}

	@GET
	@Produces("application/json")
	public JSONObject getRegistros() {

		return results;

	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/login")
	public Response login(LoginEntity logindata) {
		JSONArray compare = (JSONArray) results.get("results");
		for (int i = 0; i < compare.size(); i++) {
			if (((JSONObject) compare.get(i)).get("username").equals(logindata.getUsername())) {
				if (((JSONObject) compare.get(i)).get("password").equals(logindata.getPassword())) {
					return Response.ok("Login Correct").build();
				} else {
					return Response.ok("Password Incorrect").build();
				}
			}
		}
		return Response.ok("User not exist").build();
	}

	public boolean sonEspacios(String cad) {
		for (int i = 0; i < cad.length(); i++)
			if (cad.charAt(i) != ' ')
				return false;

		return true;
	}

}
