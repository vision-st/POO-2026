package com.duoc.poo.semana4.stack.model;

import java.util.Stack;

/**
 * Modela un historial de acciones que puede deshacer la operación más reciente.
 *
 * <p>Se utiliza {@link Stack} porque el dominio requiere el patrón LIFO:
 * la última acción en entrar es la primera que debe salir.
 */
public class HistorialAcciones {

    private final Stack<String> acciones;

    /**
     * Crea un historial vacío.
     */
    public HistorialAcciones() {
        this.acciones = new Stack<>();
    }

    /**
     * Registra una nueva acción en la cima de la pila.
     *
     * @param accion descripción de la acción realizada
     */
    public void registrar(String accion) {
        acciones.push(accion);
    }

    /**
     * Elimina y retorna la última acción registrada.
     *
     * @return última acción del historial
     */
    public String deshacerUltimaAccion() {
        return acciones.pop();
    }

    /**
     * Entrega una vista textual del contenido actual de la pila.
     *
     * @return representación de las acciones almacenadas
     */
    public String obtenerResumen() {
        return acciones.toString();
    }
}
