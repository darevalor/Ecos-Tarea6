/*
* Class Name: ProcesadorArchivos                                                         
* Name:       Daniel Arevalo                                                                      
* Date:       13/03/2016     
* Version:    1.0
 */
package co.edu.uniandes.ecos.tarea4.util;

import co.edu.uniandes.ecos.tarea4.model.BookModel;
import co.edu.uniandes.ecos.tarea4.model.ClassModel;
import co.edu.uniandes.ecos.tarea4.model.SizeRange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase tiene como objetivo leer el archivo cargado y sustraer el grupo de
 * datos
 *
 * @author Daniel
 */
public class ProcesadorArchivos {

    /**
     * Retorna el grupo de datos de tipo String
     *
     * @param rutaArchivo
     * @return Lista de LinkedList de tipo String
     * @throws Exception
     */
    public static List<SizeRange> obtenerGrupoDeDatos(String rutaArchivo) throws Exception {
        List<SizeRange> listaRetorno = new ArrayList<>();
        List<String> classNames = new ArrayList<>();
        List<Double> classLoc = new ArrayList<>();
        List<Double> numberOfMethods = new ArrayList<>();
        List<Double> sizePerItem = new ArrayList<>();
        List<String> chapterNames = new ArrayList<>();
        List<Double> numberOfPages = new ArrayList<>();
        
        ClassModel classModel = new ClassModel();
        BookModel bookModel = new BookModel();
        
        double classLocNum = 0;
        double numberOfMethodsNum = 0;
        boolean isLocMethodData = false;
        boolean isPgsChapter = false;

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        try {
            String linea = br.readLine();
            while (linea != null) {
                if (linea.contains(Constantes.LOC_METHOD_DATA)) {
                    isLocMethodData = true;
                    isPgsChapter = false;
                } else if (linea.contains(Constantes.PGS_CHAPTER)) {
                    isPgsChapter = true;
                    isLocMethodData = false;
                } else if (!linea.contains(Constantes.CLASS_NAME) && !linea.contains(Constantes.PAGES)) {
                    String[] vector = linea.split(";");

                    if (isLocMethodData && vector.length == 3) {
                        classLocNum = Double.parseDouble(vector[1].trim());
                        numberOfMethodsNum = Double.parseDouble(vector[2].trim());

                        classNames.add(vector[0].trim());
                        classLoc.add(classLocNum);
                        numberOfMethods.add(numberOfMethodsNum);
                        sizePerItem.add(classLocNum / numberOfMethodsNum);
                    } else if (isPgsChapter && vector.length == 2) {
                        chapterNames.add(vector[0].trim());
                        numberOfPages.add(new Double(vector[1].trim()));
                    }
                }

                linea = br.readLine();
            }
            classModel.setClassNames(classNames);
            classModel.setClassLoc(classLoc);
            classModel.setNumberOfMethods(numberOfMethods);
            classModel.setSizePerItem(sizePerItem);
            
            bookModel.setChapterNames(chapterNames);
            bookModel.setNumberOfPages(numberOfPages);
            
            listaRetorno.add(classModel);
            listaRetorno.add(bookModel);
        } finally {
            br.close();
        }
        return listaRetorno;
    }

    /**
     * Guarda el archivo seleccionado por el usuario en el servidor
     *
     * @param input
     * @return String con la ruta del archivo
     * @throws Exception
     */
    public static String guardarArchivoEnServidor(InputStream input) throws Exception {
        OutputStream out = null;
        String extension = ".txt";
        String fileName = "grupoDatos";
        String pathFile = "/tmp/";
        String pathFileName;
        int count = 1;
        File file;
        do {
            pathFileName = pathFile + fileName + count + extension;
            file = new File(pathFileName);
            
            count++;
        } while (file.exists());
        
        try {
            out = new FileOutputStream(pathFileName);

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = input.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } finally {
            if (out != null) {
                out.close();
            }
            if (input != null) {
                input.close();
            }
        }

        return pathFileName;
    }
}
