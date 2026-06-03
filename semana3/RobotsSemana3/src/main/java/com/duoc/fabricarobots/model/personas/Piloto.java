package com.duoc.fabricarobots.model.personas;

import com.duoc.fabricarobots.model.identidad.Rut;
import com.duoc.fabricarobots.model.ubicacion.Direccion;

/**
 * Representa al piloto responsable de operar un robot de combate.
 */
public class Piloto {

    private String codigo;
    private String nombre;
    private Rut rut;
    private Direccion direccion;

    public Piloto(String codigo, String nombre, Rut rut, Direccion direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rut=" + rut +
                ", direccion=" + direccion +
                '}';
    }
}
