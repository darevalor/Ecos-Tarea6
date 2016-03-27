/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ecos.tarea5.model;

import java.util.List;

/**
 * Clase modelo para guardar los datos obtenidos por parte del usuario y los
 * resultados obtenidos del calculo de la integracion numerica de una funcion.
 *
 * @author Daniel
 */
public class Tarea5Model {

    private Double segmentWidth;
    private Double degreesOfFreedom;
    private Double integralValue;
    private Double x;
    private List<TDistributionModel> intermediateValues;

    /**
     * Devuelve el ancho del segmento
     *
     * @return valor Double con el ancho del segmento
     */
    public Double getSegmentWidth() {
        return segmentWidth;
    }

    /**
     * Establece el ancho del segmento
     *
     * @param segmentWidth valor Double con el ancho del segmento
     */
    public void setSegmentWidth(Double segmentWidth) {
        this.segmentWidth = segmentWidth;
    }

    /**
     * Devuelve los grados de libertad
     *
     * @return valor Double con los grados de libertad
     */
    public Double getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    /**
     * Establece los grados de libertad
     *
     * @param degreesOfFreedom valor Double con los grados de libertad
     */
    public void setDegreesOfFreedom(Double degreesOfFreedom) {
        this.degreesOfFreedom = degreesOfFreedom;
    }

    /**
     * Devuelve el valor integral
     *
     * @return Double con el valor Integral
     */
    public Double getIntegralValue() {
        return integralValue;
    }

    /**
     * Establece el valor integral
     *
     * @param integralValue Double con el valor Integral
     */
    public void setIntegralValue(Double integralValue) {
        this.integralValue = integralValue;
    }

    /**
     * Devuelve el valor intermedio
     *
     * @return Double con el valor intermedio
     */
    public List<TDistributionModel> getIntermediateValues() {
        return intermediateValues;
    }

    /**
     * Establece el valor intermedio
     *
     * @param intermediateValues Double con el valor intermedio
     */
    public void setIntermediateValues(List<TDistributionModel> intermediateValues) {
        this.intermediateValues = intermediateValues;
    }

    /**
     * Devuelve el rango maximo X
     *
     * @return valor Double con el rango maximo X
     */
    public Double getX() {
        return x;
    }

    /**
     * Establece el rango maximo X
     *
     * @param x valor Double con el rango maximo X
     */
    public void setX(Double x) {
        this.x = x;
    }

}
