package com.duoc.fabricarobots.model.armamentobelico;

/**
 * Representa el sistema ofensivo de un robot de combate.
 */
public class Armamento {

    private String nombre;
    private String tipo;
    private int daño;

    public Armamento(String nombre, String tipo, int daño) {
        this.nombre = nombre;
        this.tipo = tipo;
        setDaño(daño);
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
        if (daño >= 0) {
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
