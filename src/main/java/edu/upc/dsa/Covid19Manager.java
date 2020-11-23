package edu.upc.dsa;

import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import java.util.Collection;
import java.util.List;

public interface Covid19Manager {
    public Persona nuevaPersona(String ident, String nombreApellidos, int fechaNac, String nivelSalud); /*Añade una persona al sistema*/
    public Collection<Persona> personaDisp();
    public List<Muestra> ordenarMuestra(String idMuestra); /*Devuelve la lista de muestras de una persona*/
    public int sizePersona();
    public int sizeMuestra();

    public Persona getPersona(String idMuestra);
    public Muestra getMuestra(String idMuestra);

    void addMuestra(String s);

    void addPersona(String s);
}
