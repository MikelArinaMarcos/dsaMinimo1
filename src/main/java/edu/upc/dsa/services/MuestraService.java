package edu.upc.dsa.services;
import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Api(value = "/Muestra", description = "Endpoint to Text Service")
@Path("")
public class MuestraService {

    private Covid19Manager cm;

    public MuestraService() {
        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.sizeMuestra() == 0) {
            this.cm.addMuestra("Muestra 1");
            this.cm.addMuestra("Muestra 2");
        }

        if (cm.sizeMuestra() == 0) {

            this.cm.nuevaPersona("Mikel", "Arina Marcos", 02/12/1992, "A");
            this.cm.nuevaPersona("Manuel", "Gomez Garcia", 04/01/2002, "B");
        }
    }

    @GET
    @ApiOperation(value = "Get all muestras", notes = "Muestras")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer = "List"),
    })

    @POST /*Añade una nueva muestra */
    @ApiOperation(value = "Creamos una nueva muestra", notes = "nueva muestra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestra.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path(" Añadimos persona")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMuestra(@PathParam("identidicador") String idMuestra) {

        Muestra muestra= this.cm.addMuestra(idMuestra);
        return Response.status(201).entity(persona).build();
    }
}
