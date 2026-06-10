package com.duoc.poo.semana4.arraylist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un catálogo simple de nombres almacenados en una colección dinámica.
 *
 * <p>La clase encapsula una lista para evitar que la lógica del programa manipule la
 * colección de forma desordenada desde cualquier parte. Con esto se refuerza la idea
 * de responsabilidad única y se evita exponer detalles innecesarios al {@code Main}.
 */
public class CatalogoNombres {

    private final List<String> nombres;

    /**
     * Crea un catálogo vacío listo para recibir nombres.
     */
    public CatalogoNombres() {
        this.nombres = new ArrayList<>();
    }

    /**
     * Agrega un nombre al catálogo.
     *
     * @param nombre nombre que se desea registrar
     */
    public void agregarNombre(String nombre) {
        nombres.add(nombre);
    }

    /**
     * Obtiene un nombre según su posición en la lista.
     *
     * @param indice posición solicitada
     * @return nombre almacenado en ese índice
     */
    public String obtenerNombre(int indice) {
        return nombres.get(indice);
    }

    /**
     * Elimina la primera coincidencia de un nombre dentro de la lista.
     *
     * @param nombre nombre a eliminar
     */
    public void eliminarNombre(String nombre) {
        nombres.remove(nombre);
    }

    /**
     * Retorna la cantidad actual de elementos del catálogo.
     *
     * @return tamaño de la colección
     */
    public int obtenerCantidad() {
        return nombres.size();
    }

    /**
     * Recorre la colección usando {@code for-each} e imprime cada nombre.
     */
    public void imprimirNombres() {
        for (String nombre : nombres) {
            System.out.println("- " + nombre);
        }
    }
}
