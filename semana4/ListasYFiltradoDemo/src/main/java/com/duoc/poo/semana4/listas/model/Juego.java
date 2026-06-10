package com.duoc.poo.semana4.listas.model;

/**
 * Representa un videojuego simple utilizado para ejemplos de listas y filtrado.
 *
 * @param titulo nombre del videojuego
 * @param genero categoría o tipo principal del juego
 */
public record Juego(String titulo, String genero) {

    /**
     * Entrega una representación legible del juego para mostrar en consola.
     *
     * @return texto con título y género
     */
    @Override
    public String toString() {
        return titulo + " (" + genero + ")";
    }
}
