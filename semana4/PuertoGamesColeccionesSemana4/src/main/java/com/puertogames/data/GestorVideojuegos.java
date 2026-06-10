package com.puertogames.data;

import com.puertogames.model.Videojuego;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la colección de videojuegos del sistema PuertoGames.
 *
 * <p>La clase concentra la responsabilidad de cargar, almacenar, recorrer y filtrar
 * objetos {@link Videojuego}. Esto permite que la capa {@code ui} se mantenga simple
 * y que la lógica relacionada con colecciones no quede dispersa.
 */
public class GestorVideojuegos {

    private final List<Videojuego> videojuegos;

    /**
     * Crea un gestor con una colección vacía de videojuegos.
     */
    public GestorVideojuegos() {
        this.videojuegos = new ArrayList<>();
    }

    /**
     * Carga videojuegos desde un archivo de texto ubicado en el classpath.
     *
     * <p>Cada línea debe venir en formato: {@code titulo;genero;precio}.
     * La línea se divide, se convierte a objeto y luego se agrega a la colección.
     *
     * @param nombreRecurso nombre del archivo a leer desde {@code src/main/resources}
     * @throws IOException si el recurso no existe o ocurre un error de lectura
     */
    public void cargarDesdeRecurso(String nombreRecurso) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nombreRecurso);
        if (inputStream == null) {
            throw new IOException("No se encontró el recurso: " + nombreRecurso);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                agregarVideojuego(convertirLineaAObjeto(linea));
            }
        }
    }

    /**
     * Agrega un videojuego ya construido a la colección principal.
     *
     * @param videojuego objeto a registrar
     */
    public void agregarVideojuego(Videojuego videojuego) {
        videojuegos.add(videojuego);
    }

    /**
     * Imprime todos los videojuegos cargados usando {@code for-each}.
     */
    public void mostrarTodos() {
        for (Videojuego videojuego : videojuegos) {
            System.out.println("- " + videojuego);
        }
    }

    /**
     * Imprime los videojuegos cuyo título contiene un texto específico.
     *
     * @param texto fragmento buscado dentro del título
     */
    public void buscarPorTitulo(String texto) {
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getTitulo().contains(texto)) {
                System.out.println("- Coincidencia: " + videojuego);
            }
        }
    }

    /**
     * Imprime los videojuegos que pertenecen a un género dado.
     *
     * @param genero género a filtrar
     */
    public void filtrarPorGenero(String genero) {
        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getGenero().equalsIgnoreCase(genero)) {
                System.out.println("- Filtrado: " + videojuego);
            }
        }
    }

    /**
     * Retorna la cantidad de videojuegos actualmente cargados.
     *
     * @return total de elementos en la colección
     */
    public int obtenerCantidad() {
        return videojuegos.size();
    }

    /**
     * Convierte una línea de texto delimitada por punto y coma en un objeto de dominio.
     *
     * @param linea texto en formato {@code titulo;genero;precio}
     * @return instancia de {@link Videojuego}
     */
    private Videojuego convertirLineaAObjeto(String linea) {
        String[] partes = linea.split(";");
        String titulo = partes[0];
        String genero = partes[1];
        int precio = Integer.parseInt(partes[2]);
        return new Videojuego(titulo, genero, precio);
    }
}
