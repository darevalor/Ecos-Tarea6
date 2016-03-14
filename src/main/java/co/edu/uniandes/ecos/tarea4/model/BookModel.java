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
 * Clase modelo para datos de tipo libro
 *
 * @author Daniel
 */
public class BookModel extends SizeRange {

    private List<String> chapterNames;
    private List<Double> numberOfPages;

    public BookModel() {
        chapterNames = new ArrayList<>();
        numberOfPages = new ArrayList<>();
    }

    
    /**
     * Retorna una lista con los nombres de los capitulos
     *
     * @return Lista con objetos de tipo String
     */
    public List<String> getChapterNames() {
        return chapterNames;
    }

    /**
     * Establece una lista con los nombres de los capitulos
     *
     * @param chapterNames Lista con objetos de tipo String
     */
    public void setChapterNames(List<String> chapterNames) {
        this.chapterNames = chapterNames;
    }

    /**
     * Retorna una lista con la cantidad de paginas por capitulo
     *
     * @return Lista con objetos de tipo Double
     */
    public List<Double> getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Establece una lista con la cantidad de paginas por capitulo
     *
     * @param numberOfPages Lista con objetos de tipo Double
     */
    public void setNumberOfPages(List<Double> numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

}
