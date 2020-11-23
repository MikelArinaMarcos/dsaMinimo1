package edu.upc.dsa;

import edu.upc.dsa.models.Persona;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface Covid19Manager {
    public Persona nuevaPersona(String ident, String nombreApellidos, Date fechaNac, String nivelSalud); /*Añade una persona al sistema*/
    public Collection<Persona> personaDisp();
    public List<Muestra> ordenarMuestra(String idMuestra); /*Devuelve la lista de muestras de una persona*/
    public int sizePersona();
    public int sizeMuestra();

    public Persona getPersona(String idMuestra);
}
