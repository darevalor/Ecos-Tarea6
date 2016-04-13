/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ecos.tarea6.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class CalcularTest {

    private Double x;
    private Double dof;
    private Double xi;
    private Double delta;

    public CalcularTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        x = new Double("1.1");
        dof = new Double("9");
        xi = new Double("0.22");
        delta = new Double("0.1");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of promedio method, of class Calcular.
     */
    @Test
    public void testFuncionX() {
        System.out.println("funcionX");
        Double expResult = new Double("0.37");
        Double result = Calcular.funcionX(xi,dof);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of varianza method, of class Calcular.
     */
    @Test
    public void testFactorial() {
        System.out.println("factorial");
        Double expResult = new Double("24");
        Double result = Calcular.factorial(new Double("4"));
        assertEquals(expResult, result);
    }

    /**
     * Test of desviacionEstandar method, of class Calcular.
     */
    @Test
    public void testValorIntermedio() {
        System.out.println("desviacionEstandar");
        Double expResult = new Double("0.0277");
        Double result = Calcular.valorIntermedio(new Double("0.11"), new Double(2), new Double("0.37777"));
        assertEquals(expResult, result, delta);
    }


}
