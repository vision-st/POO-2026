package com.duoc.poo.semana4.arraylist.app;

import com.duoc.poo.semana4.arraylist.model.CatalogoNombres;

/**
 * Punto de entrada del ejemplo más básico de colecciones en semana 4.
 *
 * <p>La intención didáctica de esta clase es mostrar una secuencia mínima y clara:
 * crear una colección, insertar datos, acceder por índice, eliminar y recorrer.
 *
 * <p>No hay lógica de negocio compleja aquí a propósito. Es un proyecto de arranque
 * para que el estudiante observe el comportamiento esencial de {@code ArrayList}
 * sin distraerse con otros conceptos.
 */
public class Main {

    /**
     * Ejecuta una demostración básica de operaciones sobre una colección dinámica.
     *
     * @param args argumentos de línea de comandos no utilizados
     */
    public static void main(String[] args) {
        CatalogoNombres catalogo = new CatalogoNombres();
        catalogo.agregarNombre("Mario");
        catalogo.agregarNombre("Luigi");
        catalogo.agregarNombre("Peach");

        System.out.println("Primer nombre registrado: " + catalogo.obtenerNombre(0));
        System.out.println("Cantidad inicial: " + catalogo.obtenerCantidad());

        catalogo.eliminarNombre("Luigi");

        System.out.println("Cantidad después de eliminar: " + catalogo.obtenerCantidad());
        System.out.println("Nombres actuales:");
        catalogo.imprimirNombres();
    }
}
