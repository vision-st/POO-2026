package com.duoc.fabricarobots.model.armamentobelico;

import java.util.ArrayList;

/**
 * Representa el sistema ofensivo de un robot de combate.
 *
 * Un armamento tiene un nombre, un tipo y un nivel de daño.
 * Esta clase permite separar la responsabilidad ofensiva del robot en
 * una clase independiente.
 */
public class Armamento {

    private String nombre;
    private String tipo;
    private int daño;


    /**
     * Constructor de la clase Armamento
     *
     * @param nombre nombre del armamento
     * @param tipo tipo de armamento, por ejemplo: energia, plasma o impacto
     * @param daño cantidad de daño que puede causar
     */
    public Armamento(String nombre, String tipo, int daño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        if(daño >= 0){
            this.daño = daño;
        }
    }

    @Override
    public String toString() {
        return "Armamento{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", daño=" + daño +
                '}';
    }
}
