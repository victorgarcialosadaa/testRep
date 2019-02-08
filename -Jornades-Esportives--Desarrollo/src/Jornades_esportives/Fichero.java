package Jornades_esportives;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author CRISTIAN
 */
public class Fichero {

    /**
     * Metodo de la clase Fichero que te lee un fichero y te devuelve un array con el contenido
     * @param archivo
     * @return ArrayList
     */
    public static ArrayList<Alumno> devolver_contenido_del_fichero(File archivo) {

        ArrayList<Alumno> listAlumnos = new ArrayList<>();
        Alumno alumno;                  
        FileReader fr = null;                                   //Creamos un objeto de las clases FileReader y BufferedReadeader  vacios para leer informacion
        BufferedReader br = null;

        try {
            fr = new FileReader(archivo);                       //Le añadimos valor a  los objetos fr y br con los datos del File  pasado
            br = new BufferedReader(fr);
            String linea = "";
            
            while ((linea = br.readLine()) != null) {           //Mientras el archivo no este vacio leemos linea a linea  (metodo readLine())
                String datos_separados[] = linea.split(";");    //Separamos lo leido por ; y lo añadimos en un array de strings
                alumno = new Alumno(datos_separados[0], datos_separados[1], Integer.parseInt(datos_separados[2]), datos_separados[3], datos_separados[4]);   //creamos un nuevo alumno con los datos de antes en cada posicion
                listAlumnos.add(alumno);                        //Añadimos el nuevo alumno al array de alumnos  
            }
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
        } finally {                                             // En el finally cerramos el fichero, para asegurarnos que se cierra tanto si todo va bien como si salta una excepcion.  
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                System.out.println("No hay nada que cerrar.");
            }
        }
        return listAlumnos;
    }

    /**
     * Metodo de la clase Fichero que te permite mediante un fichero y 
     * una lista de palabras escribir en el fichero la lista pasados
     * @param archivo
     * @param listalumnos
     */
    public static void escribir_en_el_fichero(File archivo, ArrayList<Alumno> listalumnos) {

        FileWriter letras = null;
        PrintWriter documento = null;

        try {
            letras = new FileWriter(archivo);                       //con el filewrite escribe letra a letra
            documento = new PrintWriter(letras);                    //con el PrintWriter escribe todo gracias a un buffer

            for (int i = 0; i < listalumnos.size(); i++) {      
                String alumnos = listalumnos.get(i).toString();
                documento.println(alumnos);                          //recogemos cada paragrafo del texto(ALumno) y lo escribimos en el File
            }
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo");
        } finally {                                                  // nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero. 
            try {
                if (null != letras) {
                    letras.close();
                }
            } catch (IOException e2) {
                System.out.println("No se pudo abrir el archivo");

            }

        }

    }
}
