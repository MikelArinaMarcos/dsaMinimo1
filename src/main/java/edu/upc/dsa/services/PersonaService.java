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
@Api(value = "/Persona", description = "Endpoint to Text Service")
@Path("")
public class PersonaService {

    private Covid19Manager cm;

    public PersonaService() {
        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.sizePersona() == 0) {
            this.cm.addPersona("Persona 1");
            this.cm.addPersona("Persona 2");
        }

        if (cm.sizePersona() == 0) {

            this.cm.nuevaPersona("Mikel", "Arina Marcos", 02/12/1992, "A");
            this.cm.nuevaPersona("Manuel", "Gomez Garcia", 04/01/2002, "B");
        }


    }

    @GET
    @ApiOperation(value = "get all Personas", notes = "Varias")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer = "List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonas() {

        Collection<Persona> personas = this.cm.personaDisp();

        GenericEntity<Collection<Muestra>> entity = new GenericEntity<Collection<Persona>>(personas) {
        };

        return Response.status(201).entity(entity).build();

    }

    @POST /*Añado una nueva persona */
    @ApiOperation(value = "Creamos una nueva persona", notes = "nueva")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path(" Añadimos persona")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPersona(@PathParam("id") String idPersona) {

        Persona persona = this.cm.addPersona(idPersona);
        return Response.status(201).entity(persona).build();
    }


    @GET
    @ApiOperation(value = "Actualizamos lista de muestras", notes = " muestras ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Muestra.class ,responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/Varios/{id}")
    public Response OrderLista(@PathParam("id")String  idPersona) {

         cm.ordenarCasos(" Muestra 1");

        List <Muestra> muestras = this.cm.ordenarmuestra(idPersona);

        GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(muestras) {
        };
        return Response.status(201).entity(entity).build();

    }

    @POST /*Añadimos una nueva muestra */
    @ApiOperation(value = "Creamos una nueva Muestra", notes = "nueva muestra")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })

    @Path("Parámetros nueva muestra")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newMuestra (("Identificador")String identificador, ("IdentificadorClinico")String identificadorClinico,("IdentificadorPersona"String identificadorPersona, ("FechaExtracción")Date fechaExtraccion,("identificadorLaboratorio") String identificadorLaboratorio) {

        Muestra muestra = this.cm.nuevaMuestra(identificador,identificadorClinico,identificadorPersona,fechaExtraccion,identificadorLaboratorio);

        List  muestras = this.cm.getPersona(identificadorPersona).getMuestrasList()List();

        GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(muestras) {
        };
        return Response.status(201).entity(entity).build();
    }
}
