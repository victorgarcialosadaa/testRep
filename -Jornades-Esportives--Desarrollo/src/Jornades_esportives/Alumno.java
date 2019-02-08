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
/**
 * Esta clase crea un Alumno con sus parametros (nombre,apellidos,edad,sexo,curso)
 * tiene 2 constructores distintos uno para crear el alumno y otro que crea la mitad de
 * un alumno para comparar con otros
 * @author CRISTIAN
 */
public class Alumno implements Comparable<Alumno> {      //El implements le dices con que comparar a la funcion

    // Atributos
    private String nombre;
    private String apellidos;
    private int edad;
    private String sexo;
    private String curso;

    //Constructor1
    public Alumno(String nombre, String apellidos, int edad, String sexo, String curso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.curso = curso;
    }

    //Constructor2
    //para crear un alumno para comparar, sin necesidad de comparar todos los datos
    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //Metodos de acceso y escritura
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    //Sobrescritura de Metodos
    /**
     * En este caso este metodo al estar sobrescrito te devolvera todos los
     * atributos de la clase donde este sobrescrito separados por puntos y comas
     * ejemplo: Felipe;Nuñesz;23;Hombre;1ero Bachillerato;
     */
    @Override
    public String toString() {
        return getNombre() + ";" + getApellidos() + ";" + getEdad() + ";" + getSexo() + ";" + getCurso();
    }

    /**
     * En este caso este metodo al estar sobrescrito te recibe como parametro un
     * Alumno y compara si són iguales ignorando las mayúsculas y minúsculas
     * ejemplo: Fernandez==fernandez? devuelve menor de 0 si es inferior , 0 si
     * es igual y más de 0 si e s superior
     *
     * @param alumno1
     * @return
     */
    @Override
    public int compareTo(Alumno alumno1) {
        return apellidos.compareToIgnoreCase((alumno1.getApellidos()));
    }

    /**
     * En este caso este metodo al estar sobrescrito te recibe como parametro un
     * Objecto cualquiera y si es un Alumno le hacemos un cast a Alumno luego le
     * comparamos los apellidos ignorando las mayúsculas y minúsculas devolvemos
     * un True o False ejemplo: Fernandez==fernandez? True!
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Alumno) {
            Alumno alumno1 = (Alumno) obj;               //cast
            String apellido1 = alumno1.getApellidos();
            if (this.apellidos.equalsIgnoreCase(apellido1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
