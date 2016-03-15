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
 * Clase modelo para datos de tipo clase
 *
 * @author Daniel
 */
public class ClassModel extends SizeRange {

    private List<String> classNames;
    private List<Double> classLoc;
    private List<Double> numberOfMethods;
    private List<Double> sizePerItem;

    /**
     * Retorna una lista con los nombres de las clases
     *
     * @return Lista con objetos de tipo String
     */
    public List<String> getClassNames() {
        return classNames;
    }

    /**
     * Establece una lista con los nombres de las clases
     *
     * @param classNames Lista con objetos de tipo String
     */
    public void setClassNames(List<String> classNames) {
        this.classNames = classNames;
    }

    /**
     * Retorna una lista con el numero de lineas de codigo por clase
     *
     * @return Lista con objetos de tipo Double
     */
    public List<Double> getClassLoc() {
        return classLoc;
    }

    /**
     * Establece una lista con el numero de lineas de codigo por clase
     *
     * @param classLoc Lista con objetos de tipo Double
     */
    public void setClassLoc(List<Double> classLoc) {
        this.classLoc = classLoc;
    }

    /**
     * Retorna una lista con el numero de metodos
     *
     * @return Lista con objetos de tipo Double
     */
    public List<Double> getNumberOfMethods() {
        return numberOfMethods;
    }

    /**
     * Establece una lista con el numero de metodos
     *
     * @param numberOfMethods Lista con objetos de tipo Double
     */
    public void setNumberOfMethods(List<Double> numberOfMethods) {
        this.numberOfMethods = numberOfMethods;
    }

    /**
     * Retorna una lista con los tamanios por metodo
     *
     * @return Lista con objetos de tipo Double
     */
    public List<Double> getSizePerItem() {
        return sizePerItem;
    }

    /**
     * Establece una lista con los tamanios por metodo
     *
     * @param sizePerItem Lista con objetos de tipo Double
     */
    public void setSizePerItem(List<Double> sizePerItem) {
        this.sizePerItem = sizePerItem;
    }

}
