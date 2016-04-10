/*
* Class Name: Tarea6Controller                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       25/03/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea6.controller;

import co.edu.uniandes.ecos.tarea6.model.TDistributionModel;
import co.edu.uniandes.ecos.tarea6.model.Tarea6Model;
import co.edu.uniandes.ecos.tarea6.util.Calcular;
import co.edu.uniandes.ecos.tarea6.util.Constantes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;
import spark.Response;

/**
 * Clase encargada de procesar las solicitudes del usuario
 *
 * @author Daniel
 */
public class Tarea6Controller {

    private final static Logger LOGGER = Logger.getLogger(Tarea6Controller.class.getCanonicalName());
    private Tarea6Model tarea6Model;

    /**
     * Se encarga de instanciar a la clase ProcesadorArchivos para cargar el
     * archivo seleccionado por el usuario
     *
     * @param request
     * @param response
     * @return String con el codigo html que contiene los resultados de los
     * calculos
     */
    public String procesarInformacion(Request request, Response response) {
        try {
            tarea6Model = new Tarea6Model();
            tarea6Model.setIntegralValue(new Double(request.queryParams("p")));
            tarea6Model.setDegreesOfFreedom(new Double(request.queryParams("dof")));
            tarea6Model.setIntermediateValues(new ArrayList<>());
            tarea6Model.setX(new Double(1));

            return calcularIntegral();
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }

    /**
     * Se encarga procesar los calculos para la integracion numerica
     *
     * @return String con el codigo html con los resultados
     */
    private String calcularIntegral() {
        StringBuilder tableHtml = new StringBuilder();
        Double sumatoriaValoresIntermedios;
        Double error;
        double d = 0.5;
        
        do{
            sumatoriaValoresIntermedios = new Double(0);
            tarea6Model.setSegmentWidth(tarea6Model.getX() / Constantes.NUMBER_OF_SEGMENTS);

            for (int i = 0; i <= Constantes.NUMBER_OF_SEGMENTS; i++) {
                TDistributionModel distributionModel = new TDistributionModel();

                if (i == 0 || i == Constantes.NUMBER_OF_SEGMENTS) {
                    distributionModel.setMultiplier(new Double(1));
                } else if ((i % 2) == 1) {
                    distributionModel.setMultiplier(new Double(4));
                } else {
                    distributionModel.setMultiplier(new Double(2));
                }
                distributionModel.setXi(tarea6Model.getSegmentWidth() * i);
                tarea6Model.getIntermediateValues().add(distributionModel);
            }

            for (TDistributionModel tdm : tarea6Model.getIntermediateValues()) {

                tdm.setFunctionX(Calcular.funcionX(tdm.getXi(), tarea6Model.getDegreesOfFreedom()));
                sumatoriaValoresIntermedios += Calcular.valorIntermedio(tarea6Model.getSegmentWidth(), tdm.getMultiplier(), tdm.getFunctionX());
            }
            
            error = Calcular.marginOfError(sumatoriaValoresIntermedios, tarea6Model.getIntegralValue());
            if(sumatoriaValoresIntermedios < tarea6Model.getIntegralValue() && !error.equals(Constantes.ERROR)){
                tarea6Model.setX(tarea6Model.getX() + d);
            }else if(sumatoriaValoresIntermedios > tarea6Model.getIntegralValue() && !error.equals(Constantes.ERROR)){
                tarea6Model.setX(tarea6Model.getX() - d);
            }
            
        }while(error.equals(Constantes.ERROR));
        
        tableHtml.append("<table border='1'>")
                .append("<tr>")
                .append("<td>X</td>")
                .append("<td>dof</td>")
                .append("<td>p</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>").append(tarea6Model.getX()).append("</td>")
                .append("<td>").append(tarea6Model.getDegreesOfFreedom()).append("</td>")
                .append("<td>").append(tarea6Model.getIntegralValue()).append("</td>")
                .append("</tr>")
                .append("</table>");
        return tableHtml.toString();
    }
}
