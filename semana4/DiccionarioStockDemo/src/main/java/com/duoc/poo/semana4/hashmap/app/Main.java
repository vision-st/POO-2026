package com.duoc.poo.semana4.hashmap.app;

import com.duoc.poo.semana4.hashmap.data.StockConsolas;

/**
 * Demuestra el uso de un diccionario basado en {@code HashMap} para manejar stock.
 */
public class Main {

    /**
     * Registra consolas, consulta stock por nombre y recorre el diccionario completo.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        StockConsolas stock = new StockConsolas();
        stock.registrar("PS5", 10);
        stock.registrar("Xbox Series X", 5);
        stock.registrar("Nintendo Switch", 8);

        System.out.println("Stock de PS5: " + stock.obtenerStock("PS5"));
        System.out.println("\nInventario completo:");
        stock.imprimirInventario();
    }
}
