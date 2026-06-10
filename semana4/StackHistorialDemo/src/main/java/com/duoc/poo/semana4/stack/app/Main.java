package com.duoc.poo.semana4.stack.app;

import com.duoc.poo.semana4.stack.model.HistorialAcciones;

/**
 * Punto de entrada para explicar el comportamiento LIFO usando un historial de acciones.
 */
public class Main {

    /**
     * Agrega acciones a una pila y luego deshace la última realizada.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        HistorialAcciones historial = new HistorialAcciones();
        historial.registrar("Mover adelante");
        historial.registrar("Saltar");
        historial.registrar("Disparar");

        System.out.println("Acciones realizadas: " + historial.obtenerResumen());
        System.out.println("Deshacer última acción: " + historial.deshacerUltimaAccion());
        System.out.println("Acciones restantes: " + historial.obtenerResumen());
    }
}
