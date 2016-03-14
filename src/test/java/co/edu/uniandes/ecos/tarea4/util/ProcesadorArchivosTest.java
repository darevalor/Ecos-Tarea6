/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ecos.tarea4.util;

import co.edu.uniandes.ecos.tarea4.model.SizeRange;
import java.io.InputStream;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Daniel
 */
public class ProcesadorArchivosTest {
    
    public ProcesadorArchivosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerGrupoDeDatos method, of class ProcesadorArchivos.
     */
    @Test
    public void testObtenerGrupoDeDatos() throws Exception {
        System.out.println("obtenerGrupoDeDatos");
        String rutaArchivo = "C:/tmp/grupoDatos.txt";
        List<SizeRange> expResult = null;
        List<SizeRange> result = ProcesadorArchivos.obtenerGrupoDeDatos(rutaArchivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarArchivoEnServidor method, of class ProcesadorArchivos.
     */
    @Ignore
    @Test
    public void testGuardarArchivoEnServidor() throws Exception {
        System.out.println("guardarArchivoEnServidor");
        InputStream input = null;
        String expResult = "";
        String result = ProcesadorArchivos.guardarArchivoEnServidor(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
