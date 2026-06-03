package com.duoc.fabricarobots.model.personas;

import com.duoc.fabricarobots.model.identidad.Rut;
import com.duoc.fabricarobots.model.ubicacion.Direccion;

public class Piloto {
    private String nombre;
    private String codigo;
    private Rut rut;
    private Direccion direccion;

    public Piloto(String nombre, String codigo, Rut rut, Direccion direccion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", rut=" + rut +
                ", direccion=" + direccion +
                '}';
    }
}
