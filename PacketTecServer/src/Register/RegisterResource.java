package Register;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;




@Path ("/register")
public class RegisterResource {
	private static List<RegisterEntity> data = new ArrayList<>(); 
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response registrar(RegisterEntity registro) {
		data.add(registro);
		return Response.ok()
				.build();
	}
	@GET
	@Produces("application/json")
	public Response getRegistros() {
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
