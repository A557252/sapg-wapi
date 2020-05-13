package net.atos.sapg.rs;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;

@Path("/")
@Api(value = "/")
@RequestScoped
public class Root {

    @GET
    @Path("/")  	     
    @Produces(MediaType.APPLICATION_JSON)
    public Response root() {
    	
    	Response.ResponseBuilder builder = null;
    	Map<String, String> responseObj = new HashMap<>();
    	
    	responseObj.put("status", "OK");
    	builder = Response.status(Response.Status.OK).entity(responseObj);
    	 return builder.build();
    }
}
