/*
* Class Name: Tarea4Controller                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       13/03/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea4.controller;

import co.edu.uniandes.ecos.tarea4.model.BookModel;
import co.edu.uniandes.ecos.tarea4.model.ClassModel;
import co.edu.uniandes.ecos.tarea4.model.SizeRange;
import co.edu.uniandes.ecos.tarea4.util.Calcular;
import co.edu.uniandes.ecos.tarea4.util.Constantes;
import co.edu.uniandes.ecos.tarea4.util.ProcesadorArchivos;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import spark.Request;
import spark.Response;

/**
 * Clase encargada de atender las solicitudes del usuario
 *
 * @author Daniel
 */
public class Tarea4Controller {

    private final static Logger LOGGER = Logger.getLogger(Tarea4Controller.class.getCanonicalName());

    /**
     * Se encarga de instanciar a la clase ProcesadorArchivos para cargar el
     * archivo seleccionado por el usuario
     *
     * @param request
     * @param response
     * @return String con el codigo html que contiene los resultados de los
     * calculos
     */
    public String cargarArchivo(Request request, Response response) {
        try {
            List<SizeRange> grupoDatos;

            MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
            request.raw().setAttribute("org.eclipse.multipartConfig", multipartConfigElement);

            Part part = request.raw().getPart("file");
            String ruta = ProcesadorArchivos.guardarArchivoEnServidor(part.getInputStream());
            grupoDatos = ProcesadorArchivos.obtenerGrupoDeDatos(ruta);

            return ejecutarCasos(grupoDatos);
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
            LOGGER.log(Level.SEVERE, null, ex);
            return ex.getMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }

    /**
     * Se encarga de ejecutar los casos de calculo entre los grupos de datos
     *
     * @param grupoDatos
     * @return String con el codigo html con los resultados de los casos
     */
    private String ejecutarCasos(List<SizeRange> grupoDatos) {
        StringBuilder tableHtml = new StringBuilder();

        for (SizeRange sizeRange : grupoDatos) {
            if (sizeRange instanceof ClassModel) {
                sizeRange.setLnX(Calcular.logaritmoNatural(((ClassModel) sizeRange).getSizePerItem()));
            } else if (sizeRange instanceof BookModel) {
                sizeRange.setLnX(Calcular.logaritmoNatural(((BookModel) sizeRange).getNumberOfPages()));
            }

            sizeRange.setPromedio(Calcular.promedio(sizeRange.getLnX()));
            sizeRange.setVarianza(Calcular.varianza(sizeRange.getLnX()));
            sizeRange.setDesvEstandar(Calcular.varianza(sizeRange.getLnX()));

            sizeRange.setRangeVS(Calcular.verySmallRange(sizeRange.getPromedio(), sizeRange.getDesvEstandar()));
            sizeRange.setRangeS(Calcular.smallRange(sizeRange.getPromedio(), sizeRange.getDesvEstandar()));
            sizeRange.setRangeM(sizeRange.getPromedio());
            sizeRange.setRangeL(Calcular.largeRange(sizeRange.getPromedio(), sizeRange.getDesvEstandar()));
            sizeRange.setRangeVL(Calcular.veryLargeRange(sizeRange.getPromedio(), sizeRange.getDesvEstandar()));
        }

        tableHtml.append("<table border='1'>")
                .append("<tr>")
                .append("<td> </td>")
                .append("<td>VS</td>")
                .append("<td>S</td>")
                .append("<td>M</td>")
                .append("<td>L</td>")
                .append("<td>VL</td>")
                .append("</tr>");
        for (SizeRange sizeRange : grupoDatos) {
            if(sizeRange instanceof ClassModel){
                System.out.println("Loc por item");
                for(Double valor : ((ClassModel) sizeRange).getSizePerItem()){
                    System.out.println(valor);
                }
            }else if(sizeRange instanceof BookModel){
                System.out.println("Paginas por capitulo");
                for(Double valor : ((BookModel) sizeRange).getNumberOfPages()){
                    System.out.println(valor);
                }
            }
            tableHtml.append("<tr><td>")
                    .append(sizeRange instanceof ClassModel ? Constantes.LOC_METHOD_DATA : sizeRange instanceof BookModel ? Constantes.PGS_CHAPTER : "")
                    .append("</td><td>")
                    .append(sizeRange.getRangeVS())
                    .append("</td><td>")
                    .append(sizeRange.getRangeS())
                    .append("</td><td>")
                    .append(sizeRange.getRangeM())
                    .append("</td><td>")
                    .append(sizeRange.getRangeL())
                    .append("</td><td>")
                    .append(sizeRange.getRangeVL())
                    .append("</td></tr>");
        }
        tableHtml.append("</table>");
        return tableHtml.toString();
    }
}
