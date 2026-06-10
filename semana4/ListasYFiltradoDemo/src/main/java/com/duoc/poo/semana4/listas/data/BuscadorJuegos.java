package com.duoc.poo.semana4.listas.data;

import com.duoc.poo.semana4.listas.model.Juego;
import java.util.List;

/**
 * Encapsula operaciones de recorrido, búsqueda y filtrado sobre una lista de juegos.
 *
 * <p>Esta clase ayuda a separar la lógica de colección del punto de entrada del
 * programa. Pedagógicamente permite introducir una primera capa "data" sin volver
 * el ejemplo innecesariamente complejo.
 */
public class BuscadorJuegos {

    private final List<Juego> juegos;

    /**
     * Crea un buscador apoyado en una lista ya existente de juegos.
     *
     * @param juegos colección que será recorrida y filtrada
     */
    public BuscadorJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    /**
     * Imprime todos los juegos disponibles usando {@code for-each}.
     */
    public void imprimirTodos() {
        for (Juego juego : juegos) {
            System.out.println("- " + juego);
        }
    }

    /**
     * Imprime solo los juegos cuyo título contiene un fragmento dado.
     *
     * @param texto fragmento buscado dentro del título
     */
    public void imprimirJuegosQueContienen(String texto) {
        for (Juego juego : juegos) {
            if (juego.titulo().contains(texto)) {
                System.out.println("- Encontrado: " + juego);
            }
        }
    }
}
