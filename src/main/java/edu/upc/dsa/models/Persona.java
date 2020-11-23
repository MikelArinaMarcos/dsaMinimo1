package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Persona {


    public String idPersona;
    public String nombreApellidos;
    public Date fechaNacimiento;
    public String nivelEnfermedad;
    public List<Muestra> muestrasList;
    Muestra muestras;

    public Persona() /*Constrcutor Vacio*/ {

    }

    public Persona(String idPersona) /*Constructor para el identificador*/ {
        this.idPersona = idPersona;
    }

    public void setMuestrasList(List<Muestra> casosList) { /* Lista las muestras de la persona */
        this.muestrasList = muestrasList;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public List<Muestra> getMuestrasList() {
        return muestrasList;
    }

    public void  addMuestra(Muestra m)
    {
        muestrasList.add(m);
    }

}
