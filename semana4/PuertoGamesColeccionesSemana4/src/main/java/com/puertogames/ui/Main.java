package com.puertogames.ui;

import com.puertogames.data.GestorVideojuegos;
import java.io.IOException;

/**
 * Punto de entrada del proyecto integrador de semana 4.
 *
 * <p>Esta clase une la lectura desde archivo externo con el uso de una colección
 * dinámica. La demostración resultante permite conversar sobre modelado de objetos,
 * separación por paquetes y operaciones frecuentes sobre {@code ArrayList}.
 */
public class Main {

    /**
     * Carga videojuegos desde un archivo, muestra el catálogo completo y ejecuta
     * ejemplos de búsqueda y filtrado.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        GestorVideojuegos gestor = new GestorVideojuegos();

        try {
            gestor.cargarDesdeRecurso("videojuegos.txt");

            System.out.println("Videojuegos cargados: " + gestor.obtenerCantidad());
            System.out.println("\nCatálogo completo:");
            gestor.mostrarTodos();

            System.out.println("\nBúsqueda por título que contiene 'Mario':");
            gestor.buscarPorTitulo("Mario");

            System.out.println("\nFiltrado por género 'Aventura':");
            gestor.filtrarPorGenero("Aventura");
        } catch (IOException e) {
            System.out.println("Error al cargar videojuegos: " + e.getMessage());
        }
    }
}
