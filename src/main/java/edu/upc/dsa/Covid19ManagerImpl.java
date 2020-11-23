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

        for (Muestra m : muestraSeleccionada.getMuestrasList()) {

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


    public int sizePersonas() {
        int ret = this.personas.size();
        logger.info("Personas" + ret);

        return ret;
    }

    public int sizeMuestras() {
        int ret = this.muestras.size();
        logger.info("Muestras" + ret);

        return ret;
    }

    public Muestra addMuestra(String identificador, String identificadorClinico, String identificadorPersona, Date fechaExtraccion, String identificadorLaboratorio) {
        Muestra nueva = new Muestra(identificador, identificadorClinico, identificadorPersona,fechaExtraccion, identificadorLaboratorio);
        this.muestras.add(nueva);
        this.muestras.get(identificador).setMuestrasList(muestras);
        logger.info("Se ha(n) añadido caso(s) al brote con id:" + identificador);
        return nueva;
    }

    public List<Muestra> muestraPersona(String idPersona) {
        return null;
    }




    public Persona getPersona (String idPersona)
    {
        for(Persona b: this.personas.values()){
            if(b.getIdPersona().equals(idPersona)){
                return b;
            }
        }
        return null;
    }
}
