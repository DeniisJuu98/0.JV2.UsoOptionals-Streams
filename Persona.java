package Ejercicio1;

import java.io.Serializable;
import java.util.Optional;

//Creamos un objeto persona con todas las clases necesarias
public class Persona implements Serializable {

    private String Nombre;
    private String Poblacion;
    private String Edad;


    public Persona() {
    }

    public Persona(String nombre, String poblacion, String edad){
        this.Nombre = nombre;
        this.Poblacion = poblacion;
        this.Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public String getEdad() {
        return Edad;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setPoblacion(String poblacion) {
        Poblacion = poblacion;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return ("Nombre:" + Nombre + ".Población:" + Poblacion + ".Edad:" + Edad +"\n");
    }
}
