package Jornades_esportives;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author CRISTIAN
 */
public class Menu {

    public static String cyan = "\033[36m";
    public static String yellow = "\033[33m";
    public static String red = "\033[31m";
    public static String white = "\033[37m";
    public static String purple = "\033[35m";
    public static String green = "\033[32m";
    public static String blue = "\033[34m";
    public static String reset = "\u001B[0m";

    /**
     * Metodo que te muestra el menú principal y devuelve mediante pedirEntero un int
     * @return  int
     */
    public static int menu() {
        int opcion_pedida = -1;
        System.out.println("\n");
        System.out.println("---------------------------------------------");
        System.out.println("             Jornades Esportives  ");
        System.out.println("---------------------------------------------");
        System.out.println("1.Registrar inscripción ");
        System.out.println("2.Consultar alumnos inscritos");
        System.out.println("3.Estado de los deportes ");
        System.out.println("4.Eliminar inscripción");
        System.out.println("5.Ver el listado de todas las inscripciones");
        System.out.println("6.Anular un deporte");
        System.out.println("7.Generador de alumnos automático");
        System.out.println("8.Salir");
        opcion_pedida = pedirEntero("\nSelecciona una opción del menu");
        return opcion_pedida;
    }
/**
 * Metodo que te lee lo que escribes y lo devuelve a una variable String
 * @param mensaje
 * @return String
 */
    public static String pedirCadena(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reset + mensaje);
        try {
            return br.readLine();
        } catch (IOException ex) {
            System.out.println("Error de entrada / salida");
        }
        return "";
    }
/**
 * Metodo que te lee lo que escribes y lo devuelve a una variable int
 * @param mensaje
 * @return int
 */
    public static int pedirEntero(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error;
        do {
            error = false;
            System.out.println(reset + mensaje);
            try {
                numero = Integer.parseInt(br.readLine());
            } catch (IOException ex) {
                System.out.println("Ha habido un error de lectura");
            } catch (NumberFormatException ex) {
                System.out.println("Has introducido una letra. Necesito un número entero!");
                error = true;
            }
        } while (error);
        return numero;
    }
/**
 *  Metodo que te muestra el menú de cursos, te lee un numero y según el numero
 * devuelve un String u otro(un curso u otro)
 * @return String
 */
    public static String pedirCurso() {

        System.out.println("--------------------------");
        System.out.println("         CURSOS");
        System.out.println("--------------------------");
        System.out.println("1.1ero Bachillerato");
        System.out.println("2.2ndo Bachillerato");
        System.out.println("3.1ero DAW");
        System.out.println("4.2ndo DAW");
        System.out.println("5.1ero ASIX");
        System.out.println("6.2ndo ASIX");
        System.out.println("7.1ero DAM");
        System.out.println("8.2ndo DAMT1");
        System.out.println("9.2ndo DAMT2");
        int opcion = Menu.pedirEntero(reset + "Elija que curso");
        String curso = "";
        switch (opcion) {
            case 1:
                curso = "1ero Bachillerato";
                break;
            case 2:
                curso = "2ndo Bachillerato";
                break;
            case 3:
                curso = "1ero DAW";
                break;
            case 4:
                curso = "2ndo DAW";
                break;
            case 5:
                curso = "1ero ASIX";
                break;
            case 6:
                curso = "2ndo ASIX";
                break;
            case 7:
                curso = "1ero DAM";
                break;
            case 8:
                curso = "2ndo DAMT1";
                break;
            case 9:
                curso = "2ndo DAMT2";
                break;
            default:
                System.err.println("No existe esa opcion");
                curso = null;

        }
        return curso;
    }
/**
 *  Metodo que te muestra el menú de los posibles sexos y segun el
 * numero que elijas devuelve un String Hombre o String Mujer
 * @return String
 */
    public static String pedirSexo() {
        String sexo = "enuco";
        System.out.println("\n");
        System.out.println(cyan+ "1.Hombre");
        System.out.println(red + "2.Mujer");
        int opcion_sexo = Menu.pedirEntero(reset+ "Sexo?");

        switch (opcion_sexo) {
            case 1:
                 sexo = "Hombre";
                return sexo;
            case 2:
                 sexo = "Mujer";
                return sexo;
            default:
                System.err.println(reset + "No existe esa opcion");
                return sexo;
        }

    }
    /**
     * 
/**
 *  Metodo que te muestra el menú de los posibles deportes y segun el
 * numero que elijas devuelve un numero  asociado a su deporte en caso de 
 * error devuelve -1
 * @return int
 */
    public static int pedirDeporte() {

        System.out.println("--------------------------");
        System.out.println("         DEPORTES");
        System.out.println("--------------------------");
        System.out.println(yellow + "1.Voleibol");
        System.out.println(blue + "2.Futbol");
        System.out.println(cyan + "3.Futbol sala");
        System.out.println(red + "4.Badminton");
        System.out.println(purple + "5.Baloncesto");
        int opcion_deporte = Menu.pedirEntero(green + "Elije deporte");

        if (opcion_deporte<=0||opcion_deporte>=6){
            
                System.err.println(reset + "No existe esa opcion");
                return -1;
        }
        return opcion_deporte;
    }

    
    public static void cambioCristian(){
                System.out.println("----------MODIFICACIÓN DE VICTOR----------");
    }
}
