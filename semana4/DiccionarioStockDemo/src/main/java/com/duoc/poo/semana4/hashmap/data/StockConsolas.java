package com.duoc.poo.semana4.hashmap.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Administra un publiinventario simple de consolas utilizando un {@link HashMap}.
 *
 * <p>Cada clave representa el nombre de una consola y cada valor representa la
 * cantidad disponible en stock.
 */
public class StockConsolas {

    private final Map<String, Integer> stock;

    /**
     * Crea un inventario vacío.
     */
    public StockConsolas() {
        this.stock = new HashMap<>();
    }

    /**
     * Inserta o actualiza el stock de una consola.
     *
     * @param consola nombre que actuará como clave
     * @param cantidad unidades disponibles
     */
    public void registrar(String consola, int cantidad) {
        stock.put(consola, cantidad);
    }

    /**
     * Obtiene el stock de una consola usando su clave.
     *
     * @param consola nombre de la consola consultada
     * @return stock disponible o {@code null} si no existe la clave
     */
    public Integer obtenerStock(String consola) {
        return stock.get(consola);
    }

    /**
     * Recorre todas las entradas del diccionario e imprime sus pares clave-valor.
     */
    public void imprimirInventario() {
        for (Map.Entry<String, Integer> entrada : stock.entrySet()) {
            System.out.println("- " + entrada.getKey() + ": " + entrada.getValue() + " unidades");
        }
    }
}
