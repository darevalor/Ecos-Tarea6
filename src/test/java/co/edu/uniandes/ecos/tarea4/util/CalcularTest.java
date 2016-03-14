/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ecos.tarea4.util;

import java.util.ArrayList;
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
public class CalcularTest {

    private List<Double> valores;
    private Double promedio;
    private Double desviacionEstandar;
    private Double varianza;
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
        promedio = new Double("2.8015");
        desviacionEstandar = new Double("0.6605");
        varianza = new Double("0.4363");
        delta = new Double("0.1");

        valores = new ArrayList();
        valores.add(new Double("1.7918"));
        valores.add(new Double("1.7918"));
        valores.add(new Double("2.1203"));
        valores.add(new Double("2.3354"));
        valores.add(new Double("2.5123"));
        valores.add(new Double("2.7973"));
        valores.add(new Double("3.0204"));
        valores.add(new Double("3.0796"));
        valores.add(new Double("3.1023"));
        valores.add(new Double("3.1355"));
        valores.add(new Double("3.3440"));
        valores.add(new Double("3.3673"));
        valores.add(new Double("4.0218"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of logaritmoNatural method, of class Calcular.
     */
    @Test
    public void testLogaritmoNatural() {
        System.out.println("logaritmoNatural");

        List valores1 = new ArrayList();
        valores1.add(new Double("6"));
        valores1.add(new Double("6"));
        valores1.add(new Double("8.3333"));
        valores1.add(new Double("10.3333"));
        valores1.add(new Double("12.3333"));
        valores1.add(new Double("16.4000"));
        valores1.add(new Double("20.5000"));
        valores1.add(new Double("21.7500"));
        valores1.add(new Double("22.2500"));
        valores1.add(new Double("23.0000"));
        valores1.add(new Double("28.3333"));
        valores1.add(new Double("29.0000"));
        valores1.add(new Double("55.8000"));

        List<Double> result = Calcular.logaritmoNatural(valores1);

        int cont = 0;

        for (Double value : result) {
            assertEquals(value, valores.get(cont++), delta);
        }
    }

    /**
     * Test of promedio method, of class Calcular.
     */
    @Test
    public void testPromedio() {
        System.out.println("promedio");
        Double expResult = promedio;
        Double result = Calcular.promedio(valores);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of varianza method, of class Calcular.
     */
    @Test
    public void testVarianza() {
        System.out.println("varianza");
        Double expResult = varianza;
        Double result = Calcular.varianza(valores);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of desviacionEstandar method, of class Calcular.
     */
    @Test
    public void testDesviacionEstandar() {
        System.out.println("desviacionEstandar");
        Double expResult = desviacionEstandar;
        Double result = Calcular.desviacionEstandar(valores);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of verySmallRange method, of class Calcular.
     */
    @Test
    public void testVerySmallRange() {
        System.out.println("verySmallRange");
        Double expResult = new Double("4.3953");
        Double result = Calcular.verySmallRange(promedio, desviacionEstandar);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of smallRange method, of class Calcular.
     */
    @Test
    public void testSmallRange() {
        System.out.println("smallRange");
        Double expResult = new Double("8.5081");
        Double result = Calcular.smallRange(promedio, desviacionEstandar);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of mediumRange method, of class Calcular.
     */
    @Test
    public void testMediumRange() {
        System.out.println("mediumRange");
        Double expResult = new Double("16.4696");
        Double result = Calcular.mediumRange(promedio);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of largeRange method, of class Calcular.
     */
    @Test
    public void testLargeRange() {
        System.out.println("largeRange");
        Double expResult = new Double("31.8811");
        Double result = Calcular.largeRange(promedio, desviacionEstandar);
        assertEquals(expResult, result, delta);
    }

    /**
     * Test of veryLargeRange method, of class Calcular.
     */
    @Test
    public void testVeryLargeRange() {
        System.out.println("veryLargeRange");
        Double expResult = new Double("61.7133");
        Double result = Calcular.veryLargeRange(promedio, desviacionEstandar);
        assertEquals(expResult, result, delta);
    }

}
