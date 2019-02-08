package Jornades_esportives;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CRISTIAN
 */
public class Main {

    public static void main(String[] args) {

        Opciones_pedidas_del_menu.creacion();

        int opcion = -1;

        while (opcion != 8) {
            opcion = Menu.menu();
            switch (opcion) {
                case 1:
                    Opciones_pedidas_del_menu.registrar_Alumno();
                    break;
                case 2:
                    Opciones_pedidas_del_menu.consultar_Alumnos_de_un_curso();
                    break;
                case 3:
                    Opciones_pedidas_del_menu.estado_deportes();
                    break;
                case 4:
                    Opciones_pedidas_del_menu.borrar_alumno();
                    break;
                case 5:
                    Opciones_pedidas_del_menu.consultar_listado_Alumnos();
                    break;
                case 6:
                    Opciones_pedidas_del_menu.borrar_deporte();
                    break;
                case 7:
                    Opciones_pedidas_del_menu.defecto();
                    break;
                case 8:
                    break;
            }

        }

    }
}
