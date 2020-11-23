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
    public Persona nuevaPersona(String ident, String nombreApellidos, int fechaNac, String nivelSalud) {
        return null;
    }

    @Override
    public Collection<Persona> personaDisp() {

        logger.info("Personas");
        return this.personas.values();
    }

    @Override
    public List<Muestra> ordenarMuestra(String idMuestra) {
        return null;
    }

    @Override
    public int sizePersona() {
        return 0;
    }

    @Override
    public int sizeMuestra() {
        return 0;
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

    public Muestra getMuestra(String idMuestra) {
        for(Muestra m: this.muestras,values()){
            if(addMuestra().getIdentificadorPersona())
        }
        return null;
    }
}
