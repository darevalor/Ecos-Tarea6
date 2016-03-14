/*
* Class Name: BookModel                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       13/03/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea4.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para mantener los valores de los rangos, la desviacion estandar, la
 * varianza y el promedio
 *
 * @author Daniel
 */
public class SizeRange {

    private Double promedio;
    private Double varianza;
    private Double desvEstandar;
    private Double rangeVS;
    private Double rangeS;
    private Double rangeM;
    private Double rangeL;
    private Double rangeVL;
    private List<Double> lnX;

    public SizeRange() {
        lnX = new ArrayList<>();
    }
    
    

    /**
     * Retorna el promedio
     *
     * @return Objeto de tipo Double
     */
    public Double getPromedio() {
        return promedio;
    }

    /**
     * Establece el promedio
     *
     * @param promedio
     */
    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    /**
     * Retorna la varianza
     *
     * @return Objeto de tipo Double
     */
    public Double getVarianza() {
        return varianza;
    }

    /**
     * Establece la varianza
     *
     * @param varianza Objeto de tipo Double
     */
    public void setVarianza(Double varianza) {
        this.varianza = varianza;
    }

    /**
     * Retorna la desviacion estandar
     *
     * @return Objeto de tipo Double
     */
    public Double getDesvEstandar() {
        return desvEstandar;
    }

    /**
     * Establece la desviacion estandar
     *
     * @param desvEstandar Objeto de tipo Double
     */
    public void setDesvEstandar(Double desvEstandar) {
        this.desvEstandar = desvEstandar;
    }

    /**
     * Retorna el rango Very Small
     *
     * @return Objeto de tipo Double
     */
    public Double getRangeVS() {
        return rangeVS;
    }

    /**
     * Establece el rango Very Small
     *
     * @param rangeVS Objeto de tipo Double
     */
    public void setRangeVS(Double rangeVS) {
        this.rangeVS = rangeVS;
    }

    /**
     * Retorna el rango Small
     *
     * @return Objeto de tipo Double
     */
    public Double getRangeS() {
        return rangeS;
    }

    /**
     * Establece el rango Small
     *
     * @param rangeS Objeto de tipo Double
     */
    public void setRangeS(Double rangeS) {
        this.rangeS = rangeS;
    }

    /**
     * Retorna el rango Medium
     *
     * @return Objeto de tipo Double
     */
    public Double getRangeM() {
        return rangeM;
    }

    /**
     * Establece el rango Medium
     *
     * @param rangeM Objeto de tipo Double
     */
    public void setRangeM(Double rangeM) {
        this.rangeM = rangeM;
    }

    /**
     * Retorna el rango Large
     *
     * @return Objeto de tipo Double
     */
    public Double getRangeL() {
        return rangeL;
    }

    /**
     * Establece el rango Large
     *
     * @param rangeL Objeto de tipo Double
     */
    public void setRangeL(Double rangeL) {
        this.rangeL = rangeL;
    }

    /**
     * Retorna el rango Very Large
     *
     * @return Objeto de tipo Double
     */
    public Double getRangeVL() {
        return rangeVL;
    }

    /**
     * Establece el rango Very Large
     *
     * @param rangeVL Objeto de tipo Double
     */
    public void setRangeVL(Double rangeVL) {
        this.rangeVL = rangeVL;
    }

    /**
     * Retorna la lista de logaritmos naturales de X
     *
     * @return Lista de Objetos de tipo Double
     */
    public List<Double> getLnX() {
        return lnX;
    }

    /**
     * Establece la lista de logaritmos naturales de X
     *
     * @param lnX Lista de Objetos de tipo Double
     */
    public void setLnX(List<Double> lnX) {
        this.lnX = lnX;
    }

}
