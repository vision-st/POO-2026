package com.puertogames.model;

public class VideoJuego {

    private final String codigo;
    private final String nombre;
    private final String genero;
    private final String plataforma;
    private final double precio;
    private final int stock;


    public VideoJuego(String codigo, String nombre, String genero, String plataforma, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "com.puertogames.model.VideoJuego{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
