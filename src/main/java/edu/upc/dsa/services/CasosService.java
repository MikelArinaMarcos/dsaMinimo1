package edu.upc.dsa.services;
import io.swagger.annotations.Api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Root resource (exposed at "myresource" path)
 */
@Api(value = "/Casos", description = "Endpoint to Text Service")
@Path("Casos")
public class CasosService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "¡Vamos!";
    }

    @Path("Nombre")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("Nombre ") String userName) {
        return "Hola " + userName;
    }

    @Path("exception")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String throwIt() throws Exception {
        throw new Exception("My Exception");
    }

}
