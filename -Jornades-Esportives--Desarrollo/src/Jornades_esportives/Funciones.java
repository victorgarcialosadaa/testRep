package Jornades_esportives;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import static Jornades_esportives.Opciones_pedidas_del_menu.badminton;
import static Jornades_esportives.Opciones_pedidas_del_menu.baloncesto;
import static Jornades_esportives.Opciones_pedidas_del_menu.futbol;
import static Jornades_esportives.Opciones_pedidas_del_menu.futbol_sala;
import static Jornades_esportives.Opciones_pedidas_del_menu.volei;


/**
 *
 * @author CRISTIAN
 */
public class Funciones {

    public static ArrayList<Alumno> listAlumnos = new ArrayList<>();
  

    /**
     * Método de la clase Funciones que a través de los parametros pasados te
     * extrae el nombre y el apellido de cada uno del parametro ArrayList y los
     * compara con el parametro Alumno y si són iguales te devuelve un True
     *
     * @param listAlumnos
     * @param alumno1
     * @return boolean
     */
    public static boolean comprobacion_Alumno(ArrayList<Alumno> listAlumnos, Alumno alumno1) {
        String nombre_acomprobar = alumno1.getNombre();
        String apellido_acomprobar = alumno1.getApellidos();
        String nombreapellido = nombre_acomprobar + apellido_acomprobar;

        for (int i = 0; i < listAlumnos.size(); i++) {
            String nombre_a_comprobar_delaLista = listAlumnos.get(i).getNombre();
            String apellido_a_comprobar_delaLista = listAlumnos.get(i).getApellidos();
            String nombreapellidoLista = nombre_a_comprobar_delaLista + apellido_a_comprobar_delaLista;
            boolean existe = nombreapellidoLista.equalsIgnoreCase(nombreapellido);
            if (existe) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método de la clase Funciones donde introduce todos el contenido del
     * parametro pasado File en un ArrayList
     *
     * @param deporte
     * @return listaAlumnos
     */
    public static ArrayList<Alumno> juntar_Alumnos_de(File deporte) {
        listAlumnos.clear();                                                               //primero vaciamos la lista ya que es una variable global
        listAlumnos = Fichero.devolver_contenido_del_fichero(deporte);
        return listAlumnos;
    }

    /**
     * Metodo de la clase Funciones donde introduce todos los contenidos de los 
     * Files en un ArrayList masivo y lo devuleve
     *
     * @return listaAlumnos
     */
    public static ArrayList<Alumno> juntar_Todos_los_Alumnos() {

        listAlumnos.clear();

        listAlumnos = Fichero.devolver_contenido_del_fichero(volei);                     //Ingresamos todos los alumnos de volei etc... en una array masivo (listAlumnos)

        ArrayList<Alumno> alumnosFutbol = Fichero.devolver_contenido_del_fichero(futbol);  //Ahora los añadimos uno a uno al ArrayList que ya contiene a todos los de volei para no sobreescribir
        for (Alumno Alumno : alumnosFutbol) {
            listAlumnos.add(Alumno);
        }
        ArrayList<Alumno> alumnosFutbol_sala = Fichero.devolver_contenido_del_fichero(futbol_sala);
        for (Alumno Alumno : alumnosFutbol_sala) {
            listAlumnos.add(Alumno);
        }
        ArrayList<Alumno> alumnosBadminton = Fichero.devolver_contenido_del_fichero(badminton);
        for (Alumno Alumno : alumnosBadminton) {
            listAlumnos.add(Alumno);
        }
        ArrayList<Alumno> alumnosBaloncesto = Fichero.devolver_contenido_del_fichero(baloncesto);
        for (Alumno Alumno : alumnosBaloncesto) {
            listAlumnos.add(Alumno);
        }
        return listAlumnos;
    }
/**
 * Método de la clase Funciones donde busca el Alumno en el File pasado y lo borra,
 * luego vuelve a escribir el fichero sin el Alumno borrado.
 * @param deporte
 * @param alumno_a_borrar 
 */
    public static void borrar_alumno_de(File deporte, Alumno alumno_a_borrar) {
        listAlumnos = Fichero.devolver_contenido_del_fichero(deporte);
       
        for (Alumno alumno1 : listAlumnos) {
            if (alumno1.equals(alumno_a_borrar)) {
                listAlumnos.remove(listAlumnos.indexOf(alumno1));
                Fichero.escribir_en_el_fichero(deporte, listAlumnos);
                break;
            }
        }
    }
    

    /**
     *  Método de la clase Funciones en el cual  comprueba si existe ese alumno 
     * en el fichero pasado si no lo encuentra lo ingresa el alumno pasdo dentro 
     * del fichero pasado
     * @param alumno1
     * @param deporte 
     * @return  boolean
     */
    public static boolean ingresar_alumno_defecto(Alumno alumno1, File deporte) {
      
        listAlumnos = Fichero.devolver_contenido_del_fichero(deporte);
        boolean existe = Funciones.comprobacion_Alumno(listAlumnos, alumno1);

        if (existe != true) {
            listAlumnos.add(alumno1);
            Fichero.escribir_en_el_fichero(deporte, listAlumnos);
            return false;
        } else {
           return true;
        }
    }
    
    
}
