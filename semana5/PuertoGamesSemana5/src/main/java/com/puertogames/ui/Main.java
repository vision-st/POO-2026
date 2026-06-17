package com.puertogames.ui;

import com.puertogames.data.GestorVideojuegos;
import com.puertogames.model.Videojuego;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorVideojuegos gestor = new GestorVideojuegos();

        try {
            gestor.cargarDesdeExcel("videojuegos.xlsx");

            System.out.println("=== PuertoGames Semana 5 ===");
            System.out.println("Total de registros cargados: " + gestor.totalRegistros());
            System.out.println();

            System.out.println("--- Listado completo ---");
            gestor.listarTodos().forEach(System.out::println);
            System.out.println();

            System.out.println("--- Busqueda por codigo: VG003 ---");
            gestor.buscarPorCodigo("VG003")
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("No se encontro el videojuego")
                    );
            System.out.println();

            System.out.println("--- Filtrado por genero: Aventura ---");
            List<Videojuego> aventura = gestor.filtrarPorGenero("Aventura");
            aventura.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo Excel: " + e.getMessage());
        }
    }
}
