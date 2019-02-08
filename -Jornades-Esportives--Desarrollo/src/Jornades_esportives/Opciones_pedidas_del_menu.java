package Jornades_esportives;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import static Jornades_esportives.Funciones.comprobacion_Alumno;
import static Jornades_esportives.Funciones.listAlumnos;

/**
 *
 * @author CRISTIAN
 */
public class Opciones_pedidas_del_menu {

    static File volei;
    static File futbol;
    static File baloncesto;
    static File futbol_sala;
    static File badminton;
    static String ruta = "deportes";

    public static String cyan = "\033[36m";
    public static String yellow = "\033[33m";
    public static String red = "\033[31m";
    public static String white = "\033[37m";
    public static String purple = "\033[35m";
    public static String green = "\033[32m";
    public static String blue = "\033[34m";
    public static String reset = "\u001B[0m";

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual crea los ficheros
     * si no existen dentro de la carpeta especificada como deportes
     */
    public static void creacion() {

        File carpeta_deportes = new File(ruta);

        if (!carpeta_deportes.exists()) {
            carpeta_deportes.mkdir();
        }
        volei = new File(ruta + File.separator + "volei.txt");
        futbol = new File(ruta + File.separator + "futbol.txt");
        baloncesto = new File(ruta + File.separator + "baloncesto.txt");
        futbol_sala = new File(ruta + File.separator + "futbol_sala.txt");
        badminton = new File(ruta + File.separator + "badminton.txt");

        try {
            volei.createNewFile();

            futbol.createNewFile();

            baloncesto.createNewFile();

            futbol_sala.createNewFile();

            badminton.createNewFile();

        } catch (IOException ex) {
            System.out.println("error al crear los deportes");
        }
    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual pedimos mediante
     * otros metodos de la clase Menu sus atributos necesarios para crear un
     * Alumno Ademas mediante otros metodos de la clase Funciones comprobamos
     * que no exista ya y si no es así finalmente lo escribimos en el File
     * pedido
     */
    public static void registrar_Alumno() {

        boolean existe = false;
        String nombre = Menu.pedirCadena("Escriba el nombre del alumno");
        String apellidos = Menu.pedirCadena("Escriba el apellido del alumno");
        int edad = Menu.pedirEntero("Escriba la edad del alumno");
        String sexo = Menu.pedirSexo();
        if (sexo.equalsIgnoreCase("enuco")) {
            return;
        }
        String curso = Menu.pedirCurso();
        if (curso == null) {
            return;
        }
        Alumno alumno1 = new Alumno(nombre, apellidos, edad, sexo, curso);

        listAlumnos = Funciones.juntar_Todos_los_Alumnos();
        existe = comprobacion_Alumno(listAlumnos, alumno1);

        if (existe) {
            System.out.println("Ya existe el alumno");
        } else {
            int opcion_deporte = Menu.pedirDeporte();
            switch (opcion_deporte) {
                case 1:
                    listAlumnos = Fichero.devolver_contenido_del_fichero(volei);
                    listAlumnos.add(alumno1);
                    Fichero.escribir_en_el_fichero(volei, listAlumnos);
                    System.out.println("\n" + reset + alumno1.getNombre() + " a sido añadid@ a " + yellow + "Voleibol" + reset + " correctamente\n");
                    break;
                case 2:
                    listAlumnos = Fichero.devolver_contenido_del_fichero(futbol);
                    listAlumnos.add(alumno1);
                    Fichero.escribir_en_el_fichero(futbol, listAlumnos);
                    System.out.println("\n" + reset + alumno1.getNombre() + " a sido añadid@ a " + blue + "Futbol" + reset + " correctamente\n");
                    break;
                case 3:
                    listAlumnos = Fichero.devolver_contenido_del_fichero(futbol_sala);
                    listAlumnos.add(alumno1);
                    Fichero.escribir_en_el_fichero(futbol_sala, listAlumnos);
                    System.out.println("\n" + reset + alumno1.getNombre() + " a sido añadid@ a " + cyan + "Futbol Sala" + reset + " correctamente\n");
                    break;
                case 4:
                    listAlumnos = Fichero.devolver_contenido_del_fichero(badminton);
                    listAlumnos.add(alumno1);
                    Fichero.escribir_en_el_fichero(badminton, listAlumnos);
                    System.out.println("\n" + reset + alumno1.getNombre() + " a sido añadid@ a " + red + "Badminton" + reset + " correctamente\n");
                    break;
                case 5:
                    listAlumnos = Fichero.devolver_contenido_del_fichero(baloncesto);
                    listAlumnos.add(alumno1);
                    Fichero.escribir_en_el_fichero(baloncesto, listAlumnos);
                    System.out.println("\n" + reset + alumno1.getNombre() + " a sido añadid@ a " + purple + "Baloncesto" + reset + " correctamente\n");
                    break;
                default:
                    if (opcion_deporte == -1) {
                        break;
                    }
            }
        }
    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual comprobamos la
     * largura de los Alumnos inscritos en cada File de distinto deporte y
     * comprobamos si para ese deporte en question es suficiente el numero de
     * inscritos
     */
    public static void estado_deportes() {
        System.out.println("\n");
        System.out.println("       *******************************");
        System.out.println("            Estado de los Deportes ");
        System.out.println("       *******************************");
        listAlumnos = Fichero.devolver_contenido_del_fichero(volei);
        System.out.println(yellow + "Alumnos inscritos a Volei:" + listAlumnos.size());

        if (4 > listAlumnos.size()) {
            System.out.println(yellow + "Mínimo son 2 por campo");
            System.out.println(yellow + "Imposible realizar un partido de Voleibol con menos de 4 personas\n");
        } else if (listAlumnos.size() % 2 != 0) {
            System.out.println(yellow + "Se necesita ser pares ");
        } else {
            System.out.println(yellow + "Listo para hacer los partidos!\n");
        }
        listAlumnos = Fichero.devolver_contenido_del_fichero(futbol);
        System.out.println( cyan + "Alumnos inscritos a Futbol:" + listAlumnos.size());
        if (listAlumnos.size() < 22) {
            System.out.println(cyan + "Mínimo son 11 por campo");
            System.out.println(cyan + "Imposible realizar un partido de Futbol con menos de 22 personas\n");
        } else {
            System.out.println(cyan + "Listo para hacer los partidos!\n");
        }
        listAlumnos = Fichero.devolver_contenido_del_fichero(futbol_sala);
        System.out.println(green + "Alumnos inscritos a Futbol Sala:" + listAlumnos.size());

        if (listAlumnos.size() < 10) {
            System.out.println(green + "Mínimo son 5 por campo");
            System.out.println(green + "Imposible realizar un partido de Futbol Sala con menos de 10 personas\n");
        } else {
            System.out.println(green + "Listo para hacer los partidos!\n");
        }
        listAlumnos = Fichero.devolver_contenido_del_fichero(badminton);
        System.out.println(red + "Alumnos inscritos a Badminton:" + listAlumnos.size());
        if (listAlumnos.size() < 2) {
            System.out.println(red + "Mínimo son 1 o 2(dobles) por campo");
            System.out.println(red + "Imposible realizar un partido de Badminton con menos de 2 personas\n");
        } else if (listAlumnos.size() % 2 != 0) {
            System.out.println(red + "Se necesita ser pares ");
        } else {
            System.out.println(red + "Listo para hacer los partidos!");
        }
        listAlumnos = Fichero.devolver_contenido_del_fichero(baloncesto);
        System.out.println(purple + "Alumnos inscritos a Baloncesto:" + listAlumnos.size());
        if (listAlumnos.size() < 10) {
            System.out.println(purple + "Mínimo son 5 por campo");
            System.out.println(purple + "Imposible realizar un partido de Baloncesto con menos de 10 personas\n");
        } else {
            System.out.println(purple + "Listo para hacer los partidos!");
        }
    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual le pedimos al
     * usuario un Nombre y Apellido a borrar y lo Primero comprobamos que exista
     * mediante otro metodo (comprobacion_Alumno()) si existe llamamos al metodo
     * borrar_alumno_de() de la clase Funciones
     */
    public static void borrar_alumno() {

        String nombre = Menu.pedirCadena("Escriba el nombre del alumno a borrar");
        String apellidos = Menu.pedirCadena("Escriba el apellido del alumno a borrar");

        Alumno alumno_a_comprobar = new Alumno(nombre, apellidos);

        if (comprobacion_Alumno(listAlumnos = Fichero.devolver_contenido_del_fichero(volei), alumno_a_comprobar)) {
            Funciones.borrar_alumno_de(volei, alumno_a_comprobar);
            System.out.println("\n" + yellow + nombre + " " + apellidos + " ha sido borrado satisfactoriamente");

        } else if (comprobacion_Alumno(listAlumnos = Fichero.devolver_contenido_del_fichero(futbol), alumno_a_comprobar)) {
            Funciones.borrar_alumno_de(futbol, alumno_a_comprobar);
            System.out.println("\n" + cyan + nombre + " " + apellidos + " ha sido borrado satisfactoriamente");

        } else if (comprobacion_Alumno(listAlumnos = Fichero.devolver_contenido_del_fichero(futbol_sala), alumno_a_comprobar)) {
            Funciones.borrar_alumno_de(futbol_sala, alumno_a_comprobar);
            System.out.println("\n" + green + nombre + " " + apellidos + " ha sido borrado satisfactoriamente");

        } else if (comprobacion_Alumno(listAlumnos = Fichero.devolver_contenido_del_fichero(badminton), alumno_a_comprobar)) {
            Funciones.borrar_alumno_de(badminton, alumno_a_comprobar);
            System.out.println("\n" + nombre + " " + apellidos + " ha sido borrado satisfactoriamente de " + red + "Badminton");

        } else if (comprobacion_Alumno(listAlumnos = Fichero.devolver_contenido_del_fichero(baloncesto), alumno_a_comprobar)) {
            Funciones.borrar_alumno_de(baloncesto, alumno_a_comprobar);
            System.out.println("\n" + purple + nombre + " " + apellidos + " ha sido borrado satisfactoriamente");

        } else {
            System.out.println("\n" + red + "No existe ese registro");
        }

    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual pedimos el curso
     * y juntamos a todos los Alumnos en un ArrayList luego lo recorremos y si
     * el curso es igual al atributo curso del Alumno lo imprime y cuenta uno
     * por cada vuelta que imprime, si no imprime nada el contador estara a cero
     * y significa que ningún alumno esta inscrito de ese curso
     */
    public static void consultar_Alumnos_de_un_curso() {
        String curso = Menu.pedirCurso();
        ArrayList<Alumno> Todos = new ArrayList<>();
        Todos = Funciones.juntar_Todos_los_Alumnos();
        int contador = 0;

        System.out.println("_____________________________________________");
        System.out.println("       *******************************");
        System.out.println("         Alumnos de " + curso);
        System.out.println("       *******************************");
        for (Alumno Alumno : Todos) {
            if (Alumno.getCurso().equals(curso)) {
                System.out.println(cyan + Alumno);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println(red + "No hay alumnos del curso 1ero Bachillerato inscritos en ningún deporte");
        }
        System.out.println("______________________________________________");
    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual juntamos en
     * arrays los Alumnos de deporte y los ordenamos con el metodo sort de la
     * clase Collections el qual ordenara por orden alfabetico, y si no esta la
     * lista vacia imprimira todos los alumnos de ese deporte, asi con los
     * demás.
     */
    public static void consultar_listado_Alumnos() {

        String alumnos = "";
        System.out.println("\nListado de todos los alumnos inscritos");
        System.out.println("***************************************************");

        System.out.println(yellow + "Alumnos de Voleibol: ");
        listAlumnos = Funciones.juntar_Alumnos_de(volei);
        Collections.sort(listAlumnos);
        if (listAlumnos.isEmpty()) {
            System.out.println(yellow + "No hay alumnos inscritos a Voleibol");
        }
        for (int i = 0; i < listAlumnos.size(); i++) {
            alumnos = listAlumnos.get(i).toString();
            System.out.println(yellow + alumnos);
        }

        System.out.println(cyan + "Alumnos de Futbol: ");
        listAlumnos = Funciones.juntar_Alumnos_de(futbol);
        Collections.sort(listAlumnos);
        if (listAlumnos.isEmpty()) {
            System.out.println(cyan + "No hay alumnos inscritos a Futbol");
        }
        for (int i = 0; i < listAlumnos.size(); i++) {
            alumnos = listAlumnos.get(i).toString();
            System.out.println(cyan + alumnos);
        }

        System.out.println(green + "Alumnos de Futbol Sala: ");
        listAlumnos = Funciones.juntar_Alumnos_de(futbol_sala);
        Collections.sort(listAlumnos);
        if (listAlumnos.isEmpty()) {
            System.out.println(green + "No hay alumnos inscritos a Futbol Sala");
        }
        for (int i = 0; i < listAlumnos.size(); i++) {
            alumnos = listAlumnos.get(i).toString();
            System.out.println(green + alumnos);
        }

        System.out.println(red + "Alumnos de Badminton: ");
        listAlumnos = Funciones.juntar_Alumnos_de(badminton);
        Collections.sort(listAlumnos);
        if (listAlumnos.isEmpty()) {
            System.out.println(red + "No hay alumnos inscritos a Badminton");
        }
        for (int i = 0; i < listAlumnos.size(); i++) {
            alumnos = listAlumnos.get(i).toString();
            System.out.println(red + alumnos);
        }

        System.out.println(purple + "Alumnos de Baloncesto: ");
        listAlumnos = Funciones.juntar_Alumnos_de(baloncesto);
        Collections.sort(listAlumnos);
        if (listAlumnos.isEmpty()) {
            System.out.println(purple + "No hay alumnos inscritos a Baloncesto");
        }
        for (int i = 0; i < listAlumnos.size(); i++) {
            alumnos = listAlumnos.get(i).toString();
            System.out.println(purple + alumnos);
        }
        System.out.println("***************************************************");
       listAlumnos=Funciones.juntar_Todos_los_Alumnos();
        System.out.println(red+"Todos los alumnos para la Andrea pesada :"+listAlumnos.size());
    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual pedimos el
     * deporte a borrar y según el numero elegido del menu borra el File, no sin
     * antes guardar todos los alumnos en un ArrayList que luego imprimira (si
     * no esta vacia) para mostrar quienes són los alumnos que estaban escritos
     * y ahora no tienen deporte.
     */
    public static void borrar_deporte() {
        String alumnos = "";
        int deporte_a_borrar = Menu.pedirDeporte();

        switch (deporte_a_borrar) {

            case 1:
                listAlumnos = Funciones.juntar_Alumnos_de(volei);
                volei.delete();
                System.out.println(yellow + "************************************");
                if (listAlumnos.isEmpty()) {
                    System.out.println(yellow + "Voleibol" + reset + " eliminado con exito\n");
                    System.out.println(yellow + "No habia alumnos inscritos a Voleibol ");
                    System.out.println(yellow + "************************************");
                    break;
                } else {
                    System.out.println(yellow + "Voleibol" + reset + " eliminado con exito\n");
                    System.out.println("Alumnos de" + yellow + " Voleibol " + reset + "que se quedan sin inscripción:");
                    for (int i = 0; i < listAlumnos.size(); i++) {
                        alumnos = listAlumnos.get(i).toString();
                        System.out.println(yellow + alumnos);
                    }
                    System.out.println(yellow + "************************************");
                    break;
                }

            case 2:
                listAlumnos = Funciones.juntar_Alumnos_de(futbol);
                futbol.delete();
                System.out.println(cyan + "************************************");
                if (listAlumnos.isEmpty()) {
                    System.out.println(cyan + "Futbol" + reset + " eliminado con exito\n");
                    System.out.println(cyan + "No habia alumnos inscritos a Futbol ");
                    System.out.println(cyan + "************************************");
                    break;
                } else {
                    System.out.println(cyan + "Futbol" + reset + " eliminado con exito\n");
                    System.out.println("Alumnos de" + cyan + " Futbol " + reset + "que se quedan sin inscripción:");
                    for (int i = 0; i < listAlumnos.size(); i++) {
                        alumnos = listAlumnos.get(i).toString();
                        System.out.println(cyan + alumnos);
                    }
                }
                System.out.println(cyan + "************************************");
                break;

            case 3:
                listAlumnos = Funciones.juntar_Alumnos_de(futbol_sala);
                futbol_sala.delete();
                System.out.println(green + "************************************");
                if (listAlumnos.isEmpty()) {
                    System.out.println(green + "Futbol sala" + reset + " eliminado con exito\n");
                    System.out.println(green + "No habia alumnos inscritos a Futbol sala ");
                    System.out.println(green + "************************************");
                    break;
                } else {
                    System.out.println(green + "Futbol sala" + reset + " eliminado con exito\n");
                    System.out.println("Alumnos de" + green + " Futbol sala " + reset + "que se quedan sin inscripción:");
                    for (int i = 0; i < listAlumnos.size(); i++) {
                        alumnos = listAlumnos.get(i).toString();
                        System.out.println(green + alumnos);
                    }
                }
                System.out.println(green + "************************************");
                break;

            case 4:
                listAlumnos = Funciones.juntar_Alumnos_de(badminton);
                badminton.delete();
                System.out.println(red + "************************************");
                if (listAlumnos.isEmpty()) {
                    System.out.println(red + "Badminton" + reset + " eliminado con exito\n");
                    System.out.println(red + "No habia alumnos inscritos a Badminton ");
                    System.out.println(red + "************************************");
                    break;
                } else {
                    System.out.println(red + "Badminton" + reset + " eliminado con exito\n");
                    System.out.println("Alumnos de" + red + " Badminton " + reset + "que se quedan sin inscripción:");
                    for (int i = 0; i < listAlumnos.size(); i++) {
                        alumnos = listAlumnos.get(i).toString();
                        System.out.println(red + alumnos);
                    }
                }
                System.out.println(red + "************************************");
                break;
            case 5:
                listAlumnos = Funciones.juntar_Alumnos_de(baloncesto);
                baloncesto.delete();
                System.out.println(purple + "************************************");
                if (listAlumnos.isEmpty()) {
                    System.out.println(purple + "Baloncesto" + reset + " eliminado con exito\n");
                    System.out.println(purple + "No habia alumnos inscritos a Baloncesto ");
                    System.out.println(purple + "************************************");
                    break;
                } else {
                    System.out.println(purple + "Baloncesto" + reset + " eliminado con exito\n");
                    System.out.println("Alumnos de" + purple + " Baloncesto " + reset + "que se quedan sin inscripción:");
                    for (int i = 0; i < listAlumnos.size(); i++) {
                        alumnos = listAlumnos.get(i).toString();
                        System.out.println(purple + alumnos);
                    }
                }
                System.out.println(purple + "************************************");
                break;
        }
    }

    /**
     * Método de la clase Opciones_pedidas_del_menu en el cual pedimos un numero
     * de alumnos a escribir y mediante unas listas de atributos genera alumnos
     * aleatoriamente y los gurada en distintos ficheros
     */
    public static void defecto() {
        //Alumnos escritos aleatoriamente
        boolean repeat;
        Alumno alumnoAleatorio = new Alumno("", "", 0, "", "");
        int numero_alumnoAleatorio = Menu.pedirEntero(reset + "Cuantos alumnos aleatorios quieres generar?");
        int contadorIngresados = 0;
        int contadorRepetidos = 0;
        String[] nombres_Hombres = {"Cristian", "Luis", "Erik", "Daniel", "Manolo"};
        String[] nombres_Mujeres = {"Cristina", "Luisa", "Erika", "Daniela", "Manolita"};
        String[] apellidos = {"Guzman", "Gulivert", "Guti", "Mendez", "Palomares", "Carrillo", "Garmindia", "Carmenyo", "Urrutia", "Carrasco", "Piesco", "Bermudez", "Hernan", "Ramirez", "Diez"};

        String[] sexos = {"Hombre", "Mujer"};
        String[] cursos = {"1ero Bachillerato", "2ndo Bachillerato", "1ero DAW", "2ndo DAW", "1ero ASIX", "2ndo ASIX", "1ero DAM", "2ndo DAMT1", "2ndo DAMT2"};
        String[] nombres_del_File = {"volei", "futbol", "futbol_sala", "badminton", "baloncesto"};

        for (int i = 0; i < numero_alumnoAleatorio; i++) {
            int edades = (int) (Math.random() * 99) + 1;
            String sexoelegido = sexos[(int) (Math.floor(Math.random() * ((sexos.length - 1) - 0 + 1) + 0))];

            if (sexoelegido.equalsIgnoreCase("Hombre")) {
                alumnoAleatorio = new Alumno(nombres_Hombres[(int) (Math.floor(Math.random() * ((nombres_Hombres.length - 1) - 0 + 1) + 0))], apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))], edades, sexos[0], cursos[(int) (Math.floor(Math.random() * ((cursos.length - 1) - 0 + 1) + 0))]);

            } else {
                alumnoAleatorio = new Alumno(nombres_Mujeres[(int) (Math.floor(Math.random() * ((nombres_Mujeres.length - 1) - 0 + 1) + 0))], apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))], edades, sexos[1], cursos[(int) (Math.floor(Math.random() * ((cursos.length - 1) - 0 + 1) + 0))]);

            }
            if (Funciones.comprobacion_Alumno(listAlumnos, alumnoAleatorio)) {
                contadorRepetidos++;

            } else {

                String nombre_del_File = nombres_del_File[(int) (Math.floor(Math.random() * ((nombres_del_File.length - 1) - 0 + 1) + 0))];
                switch (nombre_del_File) {
                    case "volei":
                        repeat = Funciones.ingresar_alumno_defecto(alumnoAleatorio, volei);
                        if (repeat) {
                             contadorRepetidos++;
                        } else {
                         contadorIngresados++;
                        }
                        break;
                    case "futbol":
                       repeat=Funciones.ingresar_alumno_defecto(alumnoAleatorio, futbol);
                        if (repeat) {
                             contadorRepetidos++;
                        } else {
                           contadorIngresados++;
                        }
                        break;
                    case "futbol_sala":
                        repeat=Funciones.ingresar_alumno_defecto(alumnoAleatorio, futbol_sala);
                   if (repeat) {
                            contadorRepetidos++;
                        } else {
                            contadorIngresados++;
                        }
                        break;
                    case "badminton":
                        repeat=Funciones.ingresar_alumno_defecto(alumnoAleatorio, badminton);
                      if (repeat) {
                            contadorRepetidos++;
                        } else {
                             contadorIngresados++;
                        }
                        break;
                    case "baloncesto":
                        repeat=Funciones.ingresar_alumno_defecto(alumnoAleatorio, baloncesto);
                         if (repeat) {
                             contadorRepetidos++;
                        } else {
                           contadorIngresados++;
                        }
                        break;
                    default:
                        break;
                }
            }

        }
        System.out.println("Has ingresado " + (contadorIngresados) + " alumnos se han repetido " + contadorRepetidos);
    }

}
