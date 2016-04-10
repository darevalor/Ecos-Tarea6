/*
* Class Name: Calcular                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       25/03/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea6.util;

/**
 * Clase encargada de realizar los calculos necesarios para la integracion
 * numerica de una funcion
 *
 * @author Daniel
 */
public class Calcular {

    /**
     * Se encarga de calcular la funcion de X de un segmento
     *
     * @param xi ancho acumulado del segmento
     * @param dof grados de libertad
     * @return Double con el valor de la funcion
     */
    public static Double funcionX(Double xi, Double dof) {
        Double functionX;
        Double gammaFunction;
        Double gammaFunctionNE;
        boolean par = ((dof % 2) == 0);

        if (!par) {
            gammaFunctionNE = factorial(((dof / 2) - 1));
            gammaFunction = factorial(((dof + 1) / 2) - 1);
        } else {
            gammaFunctionNE = factorial(((dof + 1) / 2) - 1);
            gammaFunction = factorial(((dof / 2) - 1));
        }

        gammaFunctionNE *= Math.sqrt(Math.PI);

        functionX = ((par ? gammaFunctionNE : gammaFunction)
                / (Math.pow((dof * Math.PI), 0.5) * (par ? gammaFunction : gammaFunctionNE)))
                * Math.pow((1 + ((Math.pow(xi, 2)) / dof)), ((-1 * (dof + 1)) / 2));

        return functionX;
    }

    /**
     * Calcula el factorial de un numero dado
     *
     * @param numero numero al que se calculara el factorial
     * @return Double con el resultado
     */
    public static Double factorial(Double numero) {
        Double resultado = new Double(1);

        if (numero > 0) {
            resultado = numero * factorial(numero - 1);
        }

        return resultado;
    }

    /**
     * Calcula el valor intermedio
     *
     * @param ancho ancho del segmento
     * @param multiplicador multiplicador segun el segmento
     * @param funcion funcion del segmento
     * @return Double con el valor intermedio
     */
    public static Double valorIntermedio(Double ancho, Double multiplicador, Double funcion) {
        return (ancho / 3) * multiplicador * funcion;
    }
    
    public static Double marginOfError(Double apxValue, Double exactValue){
        return Math.abs(apxValue - exactValue)/exactValue;
    }
}
