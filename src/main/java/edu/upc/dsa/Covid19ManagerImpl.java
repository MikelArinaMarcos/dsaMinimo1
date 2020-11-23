package edu.upc.dsa;

import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Muestra;
import org.apache.log4j.Logger;

import java.util.*;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19ManagerImpl manager; /* SINGLETONE*/

    static final Logger logger = Logger.getLogger(Covid19ManagerImpl.class.getName());

    HashMap<String, Persona> personas;
    List<Muestra> muestras ;
    String id;
    List<Muestra> muestrasPersonas;




    private Covid19ManagerImpl(){

        this.personas = new HashMap<String, Persona>();
        this.muestras  = new LinkedList<Muestra>();
        this.muestrasPersonas = new LinkedList<>();
    }

    public static Covid19ManagerImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/
    {
        if (manager==null) manager = new Covid19ManagerImpl();
        return manager;
    }

    public static void delete(){
        manager = null;    /* Reinicia la base de datos */
        logger.info("Instancia borrada");
    }

    public Persona addPersona(String idPersona) {
        Persona personaNueva = new Persona(idPersona); /* Crea una persona */
        this.personas.put(idPersona,personaNueva); /* Se añade con su identificador*/
        logger.info("Identificador de la persona a agregar: "+ idPersona);
        return personaNueva;
    }

    @Override
    public Collection<Persona> personaDisp() {

        logger.info("Personas");
        return this.personas.values();
    }

    public List<Muestra> ordenarMuestras(String idMuestra) {
        Persona personaSeleccionada = personas.get(idPersona);

        for (Muestra m : muestraSeleccionado.getMuestrasList()) {

            Collections.sort(personaSeleccionada.muestraList, new Comparator<Caso>() {
                @Override
                public int compare(Caso o1, Caso o2) {
                    return o1.getClasificacion().compareTo(o2.getClasificacion());
                }
            });

                Collections.sort(personaSeleccionada.muestraList, new Comparator<Caso>() {
                    @Override
                    public int compare(Caso o1, Caso o2) {

                        return o1.getFechaInforme().compareTo(o2.getFechaInforme());
                    }

                });


        }
        return personaSeleccionada.muestraList;
    }


    @Override
    public int sizeBrotes() {
        int ret = this.brotes.size();
        logger.info("size brote" + ret);

        return ret;
    }

    @Override
    public int sizeCasos() {
        int ret = this.casos.size();
        logger.info("size casos" + ret);

        return ret;
    }

    @Override
    public Caso afegirCaso(String nombre, String apellidos, String idCaso, Date fechaNacimiento, Date fechaInforme, String clasificacion, String genero, String correo, String telefono, String direccion, String idBrote) {
        Caso nuevo = new Caso (nombre,apellidos,idCaso,fechaNacimiento,fechaInforme,clasificacion,genero,correo,telefono,direccion,idBrote);
        this.casos.add(nuevo);
        this.brotes.get(idBrote).setCasosList(casos);
        logger.info("se han añadido caso(s) al brote con id:"+idBrote);
        return nuevo;


    }

    @Override
    public List<Caso> casoBrote(String idBrote) {
        return null;
    }




    public Brote getBrote (String idBrote)
    {
        for(Brote b: this.brotes.values()){
            if(b.getIdBrote().equals(idBrote)){
                return b;
            }
        }
        return null;

    }



}
