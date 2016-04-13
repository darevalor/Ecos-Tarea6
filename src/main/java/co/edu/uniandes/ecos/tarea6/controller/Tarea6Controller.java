/*
* Class Name: Tarea6Controller                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       12/04/2016     
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
     * Se encarga de realizar recibir los valores ingresados por el usuario
     * y llamar al metodo correspondiente para los calculos de la regla Simpson
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
            LOGGER.log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }

    /**
     * Se encarga de buscar el valor X dado un valor P y un valor dof
     *
     * @return String con el codigo html con los resultados
     */
    private String calcularIntegral() {
        StringBuilder tableHtml = new StringBuilder();
        Double sumatoriaValoresIntermedios;
        Double error;
        Double d = new Double("0.5");
        String estadoAnterior = "";
        String estadoActual = "";
        
        do{
            sumatoriaValoresIntermedios = new Double(0);
            tarea6Model.setSegmentWidth(tarea6Model.getX() / Constantes.NUMBER_OF_SEGMENTS);
            tarea6Model.getIntermediateValues().clear();

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
                System.out.println("\n\nIntegral (Suma): "+sumatoriaValoresIntermedios);
                tarea6Model.setX(tarea6Model.getX() + d);
                estadoAnterior = estadoActual.equals("") ? "suma" : estadoActual;
                estadoActual = "suma";
            }else if(sumatoriaValoresIntermedios > tarea6Model.getIntegralValue() && !error.equals(Constantes.ERROR)){
                tarea6Model.setX(tarea6Model.getX() - d);
                System.out.println("\n\nIntegral (Resta): "+sumatoriaValoresIntermedios);
                estadoAnterior = estadoActual.equals("") ? "resta" : estadoActual;
                estadoActual = "resta";
            }
            
            if(!estadoAnterior.equals(estadoActual))
                d = d / 2;
            
            System.out.println("P: "+tarea6Model.getIntegralValue());
            System.out.println("dof: "+tarea6Model.getDegreesOfFreedom());
            System.out.println("X: "+tarea6Model.getX());
            System.out.println("error: "+error);
            System.out.println("d: "+d);
        }while(error >= (Constantes.ERROR));
        
        tableHtml.append("<table border='1'>")
                .append("<tr>")
                .append("<td>p</td>")
                .append("<td>dof</td>")
                .append("<td>X</td>")
                .append("</tr>")
                .append("<tr>")
                .append("<td>").append(tarea6Model.getIntegralValue()).append("</td>")
                .append("<td>").append(tarea6Model.getDegreesOfFreedom()).append("</td>")
                .append("<td>").append(tarea6Model.getX()).append("</td>")
                .append("</tr>")
                .append("</table>");
        return tableHtml.toString();
    }
}
