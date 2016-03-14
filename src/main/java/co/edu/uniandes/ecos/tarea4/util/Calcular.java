/*
* Class Name: Calcular                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       14/02/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea4.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de realizar los calculos necesarios para la los rangos
 *
 * @author Daniel
 */
public class Calcular {

    /**
     * Calcula el logaritmo natural para cada item de la lista de valores.
     *
     * @param valores
     * @return Retorna una lista con los logaritmos calculados
     */
    public static List<Double> logaritmoNatural(List<Double> valores) {
        List<Double> logaritmos = new ArrayList<>();

        for (Double valor : valores) {
            logaritmos.add(Math.log(valor));
        }

        return logaritmos;
    }

    /**
     * Calcula el promedio de una lista de valores
     *
     * @param valores
     * @return El promedio de la lista dada
     */
    public static Double promedio(List<Double> valores) {
        double sumatoria = 0;

        for (Double valor : valores) {
            sumatoria += valor;
        }

        return sumatoria / valores.size();
    }

    /**
     * Calcula la varianza dado un grupo de datos
     *
     * @param valores
     * @return la varianza del grupo de datos
     */
    public static Double varianza(List<Double> valores) {
        double sumatoria = 0;

        for (Double valor : valores) {
            sumatoria += Math.pow((valor - promedio(valores)), 2);
        }

        return sumatoria / valores.size();
    }

    /**
     * Calcula la desviacion estandar de una lista de valores
     *
     * @param valores
     * @return desviacion estandar de la lista de valores
     */
    public static Double desviacionEstandar(List<Double> valores) {
        return Math.sqrt(varianza(valores));
    }

    /**
     * Calcula el rango Very Small
     *
     * @param promedio
     * @param desviacionEstandar
     * @return
     */
    public static Double verySmallRange(Double promedio, Double desviacionEstandar) {
        return Math.pow(Math.E, (promedio - (2 * desviacionEstandar)));
    }

    /**
     * Calcula el rango Small
     *
     * @param promedio
     * @param desviacionEstandar
     * @return
     */
    public static Double smallRange(Double promedio, Double desviacionEstandar) {
        return Math.pow(Math.E, (promedio - desviacionEstandar));
    }

    /**
     * Calcula el rango Medium
     *
     * @param promedio
     * @return
     */
    public static Double mediumRange(Double promedio) {
        return Math.pow(Math.E, promedio);
    }

    /**
     * Calcula el rango Large
     *
     * @param promedio
     * @param desviacionEstandar
     * @return
     */
    public static Double largeRange(Double promedio, Double desviacionEstandar) {
        return Math.pow(Math.E, (promedio + desviacionEstandar));
    }

    /**
     * Calcula el rango Very Large
     *
     * @param promedio
     * @param desviacionEstandar
     * @return
     */
    public static Double veryLargeRange(Double promedio, Double desviacionEstandar) {
        return Math.pow(Math.E, (promedio + (2 * desviacionEstandar)));
    }
}
