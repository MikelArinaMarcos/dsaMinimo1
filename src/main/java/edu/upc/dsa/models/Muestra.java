package edu.upc.dsa.models;
import edu.upc.dsa.util.RandomUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Muestra {
    String identidicador;
    String identificadorClinico;
    String identificadorPersona;
    Date fechaExtraccion;
    String identificadorLaboratorio;



    public Muestra(String identificador, String identificadorClinico, String identificadorPersona, Date fechaExtraccion, String identificadorLaboratorio) {
        this.identidicador = identificador;
        this.identificadorClinico = identificadorClinico;
        this.identificadorPersona = identificadorPersona;
        this.fechaExtraccion = fechaExtraccion;
        this.identificadorLaboratorio = identificadorLaboratorio;
    }

    public Muestra() {

    }

    public String getIdentificadorClinico() {
        return identificadorClinico;
    }

    public void setIdentificadorClinico(String identificadorClinico) {
        this.identificadorClinico = identificadorClinico;
    }

    public String getIdentificadorPersona() {
        return identificadorPersona;
    }

    public void setIdentificadorPersona(String identificadorPersona) {
        this.identificadorPersona = identificadorPersona;
    }

    public Date getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(Date fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    public String getIdentificadorLaboratorio() {
        return identificadorLaboratorio;
    }

    public void setIdentificadorLaboratorio(String identificadorLaboratorio) {
        this.identificadorLaboratorio = identificadorLaboratorio;
    }
}
