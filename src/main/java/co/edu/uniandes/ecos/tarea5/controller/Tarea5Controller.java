/*
* Class Name: Tarea5Controller                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       25/03/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea5.controller;

import co.edu.uniandes.ecos.tarea5.model.TDistributionModel;
import co.edu.uniandes.ecos.tarea5.model.Tarea5Model;
import co.edu.uniandes.ecos.tarea5.util.Calcular;
import co.edu.uniandes.ecos.tarea5.util.Constantes;
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
public class Tarea5Controller {

    private final static Logger LOGGER = Logger.getLogger(Tarea5Controller.class.getCanonicalName());
    private Tarea5Model tarea5Model;

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
            tarea5Model = new Tarea5Model();
            tarea5Model.setX(new Double(request.queryParams("xRange")));
            tarea5Model.setDegreesOfFreedom(new Double(request.queryParams("dof")));
            tarea5Model.setIntermediateValues(new ArrayList<>());
            tarea5Model.setSegmentWidth(tarea5Model.getX() / Constantes.NUMBER_OF_SEGMENTS);

            for (int i = 0; i <= Constantes.NUMBER_OF_SEGMENTS; i++) {
                TDistributionModel distributionModel = new TDistributionModel();

                if (i == 0 || i == Constantes.NUMBER_OF_SEGMENTS) {
                    distributionModel.setMultiplier(new Double(1));
                } else if ((i % 2) == 1) {
                    distributionModel.setMultiplier(new Double(4));
                } else {
                    distributionModel.setMultiplier(new Double(2));
                }
                distributionModel.setXi(tarea5Model.getSegmentWidth() * i);
                tarea5Model.getIntermediateValues().add(distributionModel);
            }

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
        Double sumatoriaValoresIntermedios = new Double(0);

        for (TDistributionModel tdm : tarea5Model.getIntermediateValues()) {

            tdm.setFunctionX(Calcular.funcionX(tdm.getXi(), tarea5Model.getDegreesOfFreedom()));
            sumatoriaValoresIntermedios += Calcular.valorIntermedio(tarea5Model.getSegmentWidth(), tdm.getMultiplier(), tdm.getFunctionX());
        }

        tarea5Model.setIntegralValue(sumatoriaValoresIntermedios);

        tableHtml.append("<table border='1'>")
                .append("<tr>")
                .append("<td>X</td>")
                .append("<td>dof</td>")
                .append("<td>p</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>").append(tarea5Model.getX()).append("</td>")
                .append("<td>").append(tarea5Model.getDegreesOfFreedom()).append("</td>")
                .append("<td>").append(tarea5Model.getIntegralValue()).append("</td>")
                .append("</tr>")
                .append("</table>");
        return tableHtml.toString();
    }
}
