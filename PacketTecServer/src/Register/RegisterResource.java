package Register;

import java.util.ArrayList;
import java.util.List;

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
	private static List<RegisterEntity> data = new ArrayList<>();
	private static JSONObject results = new JSONObject();

	@SuppressWarnings("unchecked")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response registrar(RegisterEntity registro) {
		
		data.add(registro);

		results.put("results", data);

		return Response.ok("Sucess").build();
	}

	@GET
	@Produces("application/json")
	public JSONObject getRegistros() {
		
			return results;
		

	}
	
}
