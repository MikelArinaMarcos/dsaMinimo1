package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Covid19ManagerTest {
    @Before
    public void setUp() {
        Covid19ManagerImpl.getInstance().addPersona("Persona 1");
        Covid19ManagerImpl.getInstance().addPersona("Persona 2");
        Covid19ManagerImpl.getInstance().addMuestra("Muestra 1","Arina","García",new Date (2020,11,23), "Laboratorio 1");
        Covid19ManagerImpl.getInstance().addMuestra("Muestra 2","Perez","Martinez",new Date (2020,11,23), "Laboratorio 2");
    }

    @Test
    public void CrearPersona() {

        Covid19ManagerImpl.getInstance().addPersona("Persona 3");
        assertEquals(5, Covid19ManagerImpl.getInstance().sizePersonas());
    }

    @Test
    public void CrearMuestra() {


        Covid19ManagerImpl.getInstance().addMuestra("Muestra 3","Lopez","Marcos",new Date (2020,11,23), "Laboratorio 1");
        assertEquals(3, Covid19ManagerImpl.getInstance().sizeMuestras());
    }


    @After
    public void tearDown() { Covid19ManagerImpl.getInstance().delete();}







}
