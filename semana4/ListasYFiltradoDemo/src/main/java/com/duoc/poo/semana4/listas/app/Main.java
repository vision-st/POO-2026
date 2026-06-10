package com.duoc.poo.semana4.listas.app;

import com.duoc.poo.semana4.listas.data.BuscadorJuegos;
import com.duoc.poo.semana4.listas.model.Juego;
import java.util.ArrayList;
import java.util.List;

/**
 * Ejecuta una demostración de búsqueda y filtrado usando la interfaz {@link List}.
 *
 * <p>Se declara la colección con la interfaz para reforzar que el contrato importa más
 * que la implementación concreta. En este ejemplo la implementación elegida es
 * {@link ArrayList}, pero podría cambiarse sin afectar la lógica principal.
 */
public class Main {

    /**
     * Construye una lista de juegos y muestra un filtro por coincidencia de texto.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        List<Juego> juegos = new ArrayList<>();
        juegos.add(new Juego("Mario Kart", "Carreras"));
        juegos.add(new Juego("Minecraft", "Sandbox"));
        juegos.add(new Juego("Super Mario Odyssey", "Aventura"));
        juegos.add(new Juego("FIFA 26", "Deportes"));

        BuscadorJuegos buscador = new BuscadorJuegos(juegos);

        System.out.println("Todos los juegos registrados:");
        buscador.imprimirTodos();

        System.out.println("\nJuegos que contienen la palabra Mario:");
        buscador.imprimirJuegosQueContienen("Mario");
    }
}
