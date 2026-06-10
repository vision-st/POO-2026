package com.puertogames.model;

/**
 * Representa un videojuego cargado desde una fuente de datos externa.
 *
 * <p>Esta clase modela el objeto principal con el que trabaja el sistema durante la
 * semana 4. La información se crea a partir de una línea de texto, luego se almacena
 * dentro de una colección dinámica para poder recorrerla, filtrarla y buscarla.
 */
public class Videojuego {

    private final String titulo;
    private final String genero;
    private final int precio;

    /**
     * Construye un videojuego con sus datos principales.
     *
     * @param titulo nombre del videojuego
     * @param genero género principal
     * @param precio precio referencial en pesos
     */
    public Videojuego(String titulo, String genero, int precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    /**
     * @return título del videojuego
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return género del videojuego
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return precio del videojuego
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Devuelve una representación legible del objeto para consola.
     *
     * @return texto con título, género y precio
     */
    @Override
    public String toString() {
        return titulo + " | " + genero + " | $" + precio;
    }
}
